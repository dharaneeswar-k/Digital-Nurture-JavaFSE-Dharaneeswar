class Logger {

    // Step 1: Create a private static instance of the Logger class
    private static Logger singleInstance;

    // Step 2: Make the constructor private to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created!");
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    // Step 4: Sample method to demonstrate logging
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
// Main.java
public class Main {
    public static void main(String[] args) {

        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        

        // Log messages using both instances
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances were created. Singleton failed.");
        }
    }
}
