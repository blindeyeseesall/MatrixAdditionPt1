public class ThreadOperation extends Thread {
	private int[][] matrixA;
	private int[][] matrixB;
	private int quadrant;
	
	public ThreadOperation(int[][] matrixA, int[][]matrixB, int quadrant) {
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.quadrant = quadrant;
	}
	
    @Override
    public void run() {
        
        System.out.println("Thread started: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
			//Start and end points for the quadrants
				
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }

        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}
