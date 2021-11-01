package task2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Shop implements Runnable {
    private final int[] array;
    private final AtomicLong sumMoney;
    private final LongAdder money;

    public Shop(int[] array, AtomicLong sumMoney) {
        this.money = new LongAdder();
        this.array = array;
        this.sumMoney = sumMoney;
    }

    @Override
    public void run() {
        Arrays.stream(array).forEach(money::add);
        sumMoney.addAndGet(money.sum());
    }
}
