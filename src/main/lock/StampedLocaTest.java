package lock;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLocaTest {

    private static final StampedLock lock = new StampedLock();

    @Test
    public void test() throws InterruptedException {

        Thread T1 = new Thread(() -> {
            long l1 = lock.writeLock();
            LockSupport.park();
        });
        T1.start();

        Thread.sleep(100);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.readLockInterruptibly();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        Thread.sleep(100);


        t2.interrupt();

        t2.join();
    }


}
