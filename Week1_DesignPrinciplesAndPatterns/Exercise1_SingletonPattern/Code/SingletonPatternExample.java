
class logger{

    private static logger singleInstance;
    private logger(){
        System.out.println("logger instance Created");
    }

    public static logger getInstance(){
        if (singleInstance == null){
            singleInstance = new logger();
        }
        return singleInstance;
    }

}
public class SingletonPatternExample {

    public static void main(String[] args) {
        logger log1 = logger.getInstance();
        logger log2 = logger.getInstance();

        if (log1 == log2){
            System.out.println("Both logger1 and logger2 are the same instance.");
        }else{
            System.out.println("Different instances were created. Singleton failed");
        }
    }

}
