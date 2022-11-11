package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;
import lotto.util.Util;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int count = InputView.getView();

            List<Lotto> generatedLottos = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                Lotto lotto = Lotto.create();
                generatedLottos.add(lotto);
                System.out.println(lotto.printNumbers());
            }

            System.out.println("당첨 번호를 입력해 주세요.");
            String winNumbers = Console.readLine();
            List<Integer> validatedWinNumbers = Util.isValidWinNumbers(winNumbers);

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();

            WinLotto winLotto = new WinLotto(validatedWinNumbers, Integer.parseInt(bonusNumber));


            System.out.println("당첨 통계");
            System.out.println("---");

            List<Result> results = new ArrayList<>();

            for (Lotto lotto : generatedLottos) {
                Result result = winLotto.getResult(lotto);
                results.add(result);
            }

            ResultStatistics statistics = new ResultStatistics(results);
            System.out.println(statistics.printResultStatistics());
            float totalProfitRate = Math.round((float) (statistics.getTotalProfit()) / (count * 1000) * 1000) / 10f;
            System.out.println("statistics.getTotalProfit() = " + statistics.getTotalProfit());
            System.out.println("(count * 1000) = " + (count * 1000));

            System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
