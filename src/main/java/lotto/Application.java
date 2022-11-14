package lotto;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        User user = new User();
        Host host = new Host();
        InputHandler inputHandler = new InputHandler();

        int cash = inputHandler.inputPurchaseAmount();
        int numOfLotto = user.getNumberOfAvailableLotto(cash);

        for (int i = 0; i < numOfLotto; i++) {
            Lotto lotto = host.issueLotto();
            user.buyLotto(lotto);
        }
        System.out.printf("\n%d개를 구매했습니다.", numOfLotto);
        user.showWholeLotto();

        List<Integer> winNumbers = inputHandler.inputWinNumbers();
        int bonusNumber = inputHandler.inputBonusNumber();
        host.registerWinningInformation(winNumbers, bonusNumber);

        StatisticsAnalyzer statisticsAnalyzer = new StatisticsAnalyzer(winNumbers, bonusNumber);
        System.out.println("당첨 통계\n---\n");
        statisticsAnalyzer.showWinResult();

        double rateOfReturn = statisticsAnalyzer.calculateRateOfReturn(user.getWholeLotto());
        System.out.printf("총 수익률은 %f%%입니다.", rateOfReturn);
    }
}
