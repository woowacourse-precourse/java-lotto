package lotto;


import java.util.List;

public class Application {
    public static int LOTTERY_PRICE = 1000;

    public static void main(String[] args) {
        InputOutput inputOutput = new InputOutput(LOTTERY_PRICE);
        LottoPublisher lottoPublisher = new LottoPublisher(LOTTERY_PRICE);

        int money = inputOutput.getMoney();
        List<Lotto> lottos = lottoPublisher.publish(money);

        inputOutput.printLottos(lottos);

        List<Integer> winningNums = inputOutput.getWinningNums();
        int bonusNum = inputOutput.getBonusNum();
        inputOutput.validateBonusNum(bonusNum, winningNums);
    }
}
