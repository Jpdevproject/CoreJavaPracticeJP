package singleton;

public class ThreadSafeSingleton {
    private ThreadSafeSingleton(){

    }
    private static class Holder{
        private static final ThreadSafeSingleton  INSTANCE=new ThreadSafeSingleton();
    }
    public static ThreadSafeSingleton getInstance(){
        return Holder.INSTANCE;
    }
    public static void main(String[] args) {
        ThreadSafeSingleton result = ThreadSafeSingleton.getInstance();
        System.out.println(result);

    }
}
