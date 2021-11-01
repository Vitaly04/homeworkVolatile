package task1;

public class User implements Runnable{
    private final int TIMEOUT = 3000;
    private Toy toy;

    public User(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void run() {
        int numberOfIterations = 5;
        for (int i = 0; i < numberOfIterations; i++) {
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!toy.isTumbler()) {
                toy.setTumbler(true);
                System.out.println("Тумблер включен");
            }
        }
    }
}
