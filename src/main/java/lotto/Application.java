package lotto;

import lotto.domain.Lotto;
import lotto.domain.Report;
import lotto.domain.View;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    static View view = new View();

    public static void main(String[] args) {
        try {
            String inputMoney = view.inputPrint();
            Lotto.checkIsInt(inputMoney);
            int lottoCount = Lotto.calculate(inputMoney);
            view.countPrint(lottoCount);
            List<Lotto> allLotto = Lotto.createLotto(lottoCount);

            String inputNumbers = view.numbersPrint();
            Winning.addWinning(inputNumbers);

            String inputBonus = view.bonusPrint();
            Winning.addBonus(inputBonus);

            int totalPrize = Report.totalPrize(allLotto);
            double returnRate = Report.returnRate(lottoCount * 1000, totalPrize);
            view.reportPrint(Report.winningCount, returnRate);
        } catch (IllegalArgumentException e) {
            Winning.numbers = new ArrayList<>();
            Report.winningCount = new Integer[]{0, 0, 0, 0, 0, 0};
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}