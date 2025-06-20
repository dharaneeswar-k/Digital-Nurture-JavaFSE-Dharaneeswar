
<<<<<<< HEAD
class logger{

    private static logger singleInstance;
    private logger(){
        System.out.println("logger instance Created");
    }

    public static logger getInstance(){
        if (singleInstance == null){
            singleInstance = new logger();
=======
    private static Logger singleInstance;

    private Logger() {
        System.out.println("Logger instance created!");
    }

    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
>>>>>>> da9e2f6705035b66d9a7126676a073bf8fd07ed7
        }
        return singleInstance;
    }

<<<<<<< HEAD
=======
    public void log(String message) {
        System.out.println("Log: " + message);
    }
>>>>>>> da9e2f6705035b66d9a7126676a073bf8fd07ed7
}
public class Singleton {

    public static void main(String[] args) {
        logger log1 = logger.getInstance();
        logger log2 = logger.getInstance();

<<<<<<< HEAD
        if (log1 == log2){
=======
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
>>>>>>> da9e2f6705035b66d9a7126676a073bf8fd07ed7
            System.out.println("Both logger1 and logger2 are the same instance.");
        }else{
            System.out.println("Different instances were created. Singleton failed");
        }
    }

}
