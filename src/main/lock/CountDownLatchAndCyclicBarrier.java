package lock;

import org.junit.Test;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchAndCyclicBarrier {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2,() ->{

        System.out.println("3");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3.0");
    });

    @Test
    public void test() throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("1");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        Thread thread1 = new Thread(() -> {
            System.out.println("2");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread1.start();



        Thread.sleep(4000);


    }




}
