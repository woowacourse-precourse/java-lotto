package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        LotteryNumber lotteryNumber = new LotteryNumber(input.getMoney());
        lotteryNumber.informLotteryNumbers();
        input.enterNumbers();
        Lotto lotto = new Lotto(input.getNumbers());
    }
}
