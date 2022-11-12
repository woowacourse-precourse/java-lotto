package lotto;

import java.util.function.Function;

public enum Win {
    firstPlace(6, 2000000000, num -> num * 2000000000),
    secondPlace(5, 30000000, num -> num * 30000000),
    thirdPlace(5, 1500000, num -> num * 1500000),
    fourthPlace(4, 50000, num -> num * 50000),
    fifthPlace(3, 5000, num -> num * 5000);

    private int cntCorrectNumber;
    private int prize;
    private Function<Long, Long> totalPrize;

    Win(int cntCorrectNumber, int prize, Function <Long, Long> totalPrize){
        this.cntCorrectNumber = cntCorrectNumber;
        this.prize = prize;
        this.totalPrize = totalPrize;
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

