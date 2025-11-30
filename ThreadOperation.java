public class ThreadOperation extends Thread {
    @Override
    public void run() {
        
        System.out.println("New Thread started: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }

        System.out.println("New Thread finished: " + Thread.currentThread().getName());
    }
}
