package lotto;

import java.util.function.Function;

public enum Win {
    WIN60(0,6, 2000000000, num -> num * 2000000000),
    WIN51(1,5, 30000000, num -> num * 30000000),
    WIN50(2, 5, 1500000, num -> num * 1500000),
    WIN40(3, 4, 50000, num -> num * 50000),
    WIN30(4, 3, 5000, num -> num * 5000);

    private int key;
    private int cntCorrectNumber;
    private int prize;
    private Function<Long, Long> totalPrize;

    Win(int key, int cntCorrectNumber, int prize, Function <Long, Long> totalPrize){
        this.key = key;
        this.cntCorrectNumber = cntCorrectNumber;
        this.prize = prize;
        this.totalPrize = totalPrize;
    }

    public int getKey(){
        return key;
    }

    public int getCntCorrectNumber() {
        return cntCorrectNumber;
    }

    public int getPrize(){
        return prize;
    }

    public long calculateTotalPrize(long num){
        return totalPrize.apply(num);
    }
}

