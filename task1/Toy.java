package task1;

public class Toy implements Runnable{
    private volatile boolean tumbler = false;

    public boolean isTumbler() {
        return tumbler;
    }

    public void setTumbler(boolean tumbler) {
        this.tumbler = tumbler;
    }

    @Override
    public void run() {
        while (true) {
            if (tumbler) {
                tumbler = false;
                System.out.println("Тумблер выключен");
            }
        }
    }
}
