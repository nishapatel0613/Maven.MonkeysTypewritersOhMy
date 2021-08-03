package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    public String copied;

    private ReentrantLock lock = new ReentrantLock();
    public SafeCopier(String toCopy){
        super(toCopy);
    }

    public void run() {
        lock.lock();
        try {
            while (stringIterator.hasNext()) {
                if (stringIterator.hasNext()) {
                    copied += stringIterator.next() + " ";
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }
}
