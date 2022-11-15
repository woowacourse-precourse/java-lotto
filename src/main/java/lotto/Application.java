package lotto;


import java.util.EnumMap;
import java.util.List;

public class Application {
    public static int LOTTERY_PRICE = 1000;
    private static InputOutput inputOutput;
    private static LottoPublisher lottoPublisher;
    private static LottoResultCalculator lottoResultCalculator;

    public static void main(String[] args) {
        try {
            init();
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void init() {
        inputOutput = InputOutput.getInstance();
        lottoPublisher = LottoPublisher.getInstance();
        lottoResultCalculator = LottoResultCalculator.getInstance();
    }

    private static void start() {
        int money = inputOutput.getMoney();
        List<Lotto> lottos = lottoPublisher.publish(money);
        inputOutput.printLottos(lottos);

        List<Integer> winningNums = inputOutput.getWinningNums();
        int bonusNum = inputOutput.getBonusNum();
        inputOutput.validateBonusNum(bonusNum, winningNums);

        lottoResultCalculator.setWinningNums(winningNums);
        lottoResultCalculator.setBonusNum(bonusNum);

        EnumMap<Rank, Integer> ranks = lottoResultCalculator.calRankAll(lottos);
        double rateOfReturn = lottoResultCalculator.calRateOfReturn(lottoResultCalculator.calWinningAmount(ranks),
                money);

        inputOutput.printResult(ranks, rateOfReturn);
    }
}
