class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + getName() + ": " + i);
            try {
                if (getName().equals("Thread-1")) {
                    Thread.sleep(2000);
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread_1 = new MyThread();
        MyThread thread_2 = new MyThread();

        thread.start();
        thread_1.start();
        thread_2.start();
    }
}