 import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    // There are 5 forks represented by 5 reentrant locks
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // Determine the fork indices for this philosopher
        int leftForkIdx = philosopher;
        int rightForkIdx = (philosopher + 1) % 5;

        // Assign first and second locks based on philosopher ID parity
        ReentrantLock firstLock;
        ReentrantLock secondLock;
        Runnable firstPick;
        Runnable secondPick;
        Runnable firstPut;
        Runnable secondPut;

        if (philosopher % 2 == 0) {
            // Even philosopher: Left fork first, then Right fork
            firstLock = forks[leftForkIdx];
            secondLock = forks[rightForkIdx];
            firstPick = pickLeftFork;
            secondPick = pickRightFork;
            firstPut = putLeftFork;
            secondPut = putRightFork;
        } else {
            // Odd philosopher: Right fork first, then Left fork
            firstLock = forks[rightForkIdx];
            secondLock = forks[leftForkIdx];
            firstPick = pickRightFork;
            secondPick = pickLeftFork;
            firstPut = putRightFork;
            secondPut = putLeftFork;
        }

        // Acquire forks in the predetermined order
        firstLock.lock();
        try {
            secondLock.lock();
            try {
                // Both forks acquired safely: perform actions
                firstPick.run();
                secondPick.run();
                eat.run();
                firstPut.run();
                secondPut.run();
            } finally {
                // Always unlock the second fork
                secondLock.unlock();
            }
        } finally {
            // Always unlock the first fork
            firstLock.unlock();
        }
    }
}