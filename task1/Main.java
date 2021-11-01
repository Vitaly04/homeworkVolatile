package task1;

public class Main {

    public static void main(String[] args) {
        Toy toy = new Toy();
        User user = new User(toy);
        Thread thread1 = new Thread(user);
        Thread thread2 = new Thread(toy);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
}
