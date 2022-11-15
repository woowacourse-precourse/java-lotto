package lotto;

public class Judgement {
    public static int buyLotto(int money) {
        int numberOfLotteries;
        numberOfLotteries = money/1000;
        return numberOfLotteries;
    }
}
