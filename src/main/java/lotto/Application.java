package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();
        StatisticsAnalyzer statisticsAnalyzer = new StatisticsAnalyzer();
        List<Integer> winNumbers = new ArrayList<>();
        int bonusNumber;

        System.out.println("구입금액을 입력해 주세요.");
        int cash = Integer.parseInt(Console.readLine());

        int numOfLotto = user.getNumberOfAvailableLotto(cash);
        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> randomNumbers = numberGenerator.generateSixRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            user.buyLotto(lotto);
        }
        System.out.printf("\n%d개를 구매했습니다.", numOfLotto);
        user.showWholeLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        for (int i = 0; i < 6; i++) {
            int number = Integer.parseInt(Console.readLine());
            winNumbers.add(number);
        }
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println("당첨 통계\n---\n");
        statisticsAnalyzer.showWinResult();

        double rateOfReturn = statisticsAnalyzer.calculateRateOfReturn(user.getWholeLotto());
        System.out.printf("총 수익률은 %f%%입니다.", rateOfReturn);
    }
}
