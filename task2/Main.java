package task2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static int[] generationArray(int size, int max) {
        int min = 0;
        return new Random().ints(size, min, max).toArray();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array1 = generationArray(5, 10);
        int[] array2 = generationArray(5, 10);
        int[] array3 = generationArray(5, 10);
        AtomicLong sumMoney = new AtomicLong();
        Runnable shop1 = new Shop(array1, sumMoney);
        Runnable shop2 = new Shop(array2, sumMoney);
        Runnable shop3 = new Shop(array3, sumMoney);
        Thread thread1 = new Thread(null, shop1, "Магазин 1");
        Thread thread2 = new Thread(null, shop2, "Магазин 2");
        Thread thread3 = new Thread(null, shop3, "Магазин 3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Общая сумма - " + sumMoney.get());
    }
}
