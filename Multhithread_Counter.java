public class MultithreadedCounter {
    private static int counter = 0; // Added missing data type int
    
    public static void main(String[] args) {
        Thread thread1 = new Thread (() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (MultithreadedCounter.class) { // Added synchronization to prevent race condition
                    counter++;
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (MultithreadedCounter.class) { // Added synchronization to prevent race condition
                    counter++;
                }
            }
        });
        
        thread1.start(); // Added start() to begin execution of threads
        thread2.start();
        
        try {
            thread1.join(); // Added join() to wait for threads to finish execution
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter: " + counter);
    }
}
