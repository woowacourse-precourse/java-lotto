package lotto;

public class Earning {

    private static final int firstPrize = 2_000_000_000;
    private static final int secondPrize = 30_000_000;
    private static final int thirdPrize = 1_500_000;
    private static final int forthPrize = 50_000;
    private static final int fifthPrize = 5000;

    public int calculate(int sameCmt, int bonusCorrect) {
        if(sameCmt == 6) return firstPrize;
        if(sameCmt == 5 && bonusCorrect == 1) return secondPrize;
        if(sameCmt == 5) return thirdPrize;
        if(sameCmt == 4) return forthPrize;
        if(sameCmt == 3) return fifthPrize;
        return 0;
    }
}
