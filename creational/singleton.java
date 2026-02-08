// Basic Singleton Pattern
/*
Basic Singleton Pattern
This pattern is used to create a singleton class.
It is a simple singleton class that is not thread-safe.
*/
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
Synchronized Singleton Pattern (Thread-Safe)
This pattern is used to create a thread-safe singleton class.
Synchronized keyword is used to ensure that only one thread can access the getInstance method at a time.
But, it is a performance bottleneck because it is a synchronized method.
*/
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
/*
Double-Checked Locking Singleton Pattern (Thread-Safe)
This pattern is used to create a thread-safe singleton class.
Volatile keyword is used to ensure that the instance is not cached or stored in the CPU cache.
JVM first allocates memory, then initializes the instance, then assigns the memory reference to the instance.
There is a chance that the instance is not initialized before the memory is assigned to the instance.
So, we use the volatile keyword to ensure that the instance is not cached or stored in the CPU cache and updated references are visible to all threads. 
*/
public class Singelton{
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance ==null){
            synchronized(Singleton.class){
                if(instance ==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


/*
Eager Initialization Singleton Pattern
This pattern is used to create a singleton class.
It is thread safe. 
*/
public class Singleton{
    private final static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}

// ENUM
public enum Singleton{
    INSTANCE;

    public void doSomething(){
        System.out.println("Doing something...");
    }
}

/*
Break Safe Singleton Pattern 
Breaking means somehow our private Constructor is being called from outside the class.
Breaking may happen in many ways:
1. Reflection  ---> access modifier violation
2. Deserialization ---> by default creates a new instance of the class
3. Cloning
4. Multiple Class Loaders 
*/
public class Singleton{
    private static Singleton instance;

    private Singleton(){
        // Safety againt reflection 
        if(instance !=null){
            throw new RuntimeException("Singleton instance already created");
        }
    }

    public static Singleton getInstance(){
        if(instance ==null){
            instance = new Singleton();
        }
        return instance;
    }
 

    // Safety againt Deserialization
    private Object readResolve(){
        return instance;
    }


    // Safety againt Cloning
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}

