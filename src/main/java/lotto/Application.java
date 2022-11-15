package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Report;
import lotto.domain.Winning;

import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        try {
            String inputMoney = inputPrint();
            Lotto.checkIsInt(inputMoney);
            int lottoCount = Lotto.calculate(inputMoney);
            List<Lotto> allLotto = Lotto.createLotto(lottoCount);
            countPrint(lottoCount);

            String inputNumbers = numbersPrint();
            Winning.addWinning(inputNumbers);

            String inputBonus = bonusPrint();
            Winning.addBonus(inputBonus);

            int totalPrize = Report.totalPrize(allLotto);
            double returnRate = Report.returnRate(lottoCount * 1000, totalPrize);
            reportPrint(Report.winningCount, returnRate);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }

    public static String inputPrint() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void countPrint(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static String numbersPrint() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusPrint() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void reportPrint(Integer[] winningCount, double returnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningCount[1] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCount[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount[4] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCount[5] + "개");
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}