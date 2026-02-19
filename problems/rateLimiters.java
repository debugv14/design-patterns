/*
A rate limiter restricts the intended or unintended excessive usage of a system
by regulating the number of requests made to/from it by discarding the surplus ones.
Rate limiters are used to prevent abuse, DDOS attacks, and to ensure the stability of the system.
Rate limiting is usually applied per access token or per user or per region/IP.
*/


/*
Token Bucket Rate Limiter
This is a simple rate limiter that uses a token bucket to limit the rate of requests.
The token bucket is a fixed size bucket that is filled with tokens at a fixed rate.
 */

public class TokenBucketRateLimiter{
    private final long bucketCapacity;
    private final long refillRatePerSec;
    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(long bucketCapacity, long refillRate){
        this.bucketCapacity = bucketCapacity;
        this.refillRatePerSec = refillRatePerSec;
        this.tokens = bucketCapacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(){
        refillTokens();
        if(tokens >= 1){
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refillTokens(){
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRefillTime;
        double tokensToAdd = (elapsedTime / 1000.0) * refillRatePerSec;
        tokens = Math.min(tokens + tokensToAdd, bucketCapacity);
        lastRefillTime = currentTime;
    }    
}

/*
Leaky Bucket Rate Limiter
This is a simple rate limiter that uses a leaky bucket to limit the rate of requests.
Bucket leaks at a fized rate. If the bucket is full, the request is dropped.
If the bucket is not full, the request is added to the bucket.
*/
public class LeakyBucketRateLimiter{
    private final long bucketCapacity;
    private final long leakRatePerSec;
    private final long lastLeakTime;
    private final Queue<Long> leakTime = new LinkedList<>();

    public LeakyBucketRateLimiter(long bucketCapacity, long leakRatePerSec){
        this.bucketCapacity = bucketCapacity;
        this.leakRatePerSec = leakRatePerSec;
        this.lastLeakTime = System.currentTimeMillis();
        this.leakTime = new LinkedList<>();
    }

    public synchronized boolean allowRequest(){
        leak(); 
        long currentTime = System.currentTimeMillis();
        if(leakTime.size() < bucketCapacity){
            leakTime.add(currentTime);
            return true;
        }
        return false;
    }

    private void leak(){
        Thread thread = new Thread(() -> {
            while(true){
                try{
                    Thread.sleep(1000/leakRatePerSec);
                    long currentTime = System.currentTimeMillis();
                    while(!leakTime.isEmpty() && currentTime - leakTime.peek() > 1000){
                        leakTime.poll();
                    }
                    if(leakTime.size() < bucketCapacity){
                        leakTime.add(currentTime);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}