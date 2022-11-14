package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.calculateIncome;
import lotto.Model.lottoResult;
import lotto.View.input;
import lotto.View.output;
import lotto.Model.lottoGenerator;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    List<List<Integer>> groupLotto = new ArrayList<>();
    lottoGenerator lottogenerator = new lottoGenerator();
    List<Integer> winLotto = new ArrayList<>();
    int amountLotto = 0;
    int bonusNum = 0;
    List<Integer> winResult = new ArrayList<>();

    public void start() {
        // 구매금액 입력
        output.printInputMoney();
        amountLotto = input.inputMoney();

        // 구매 로또 출력
        output.printAmount(amountLotto);
        groupLotto = lottogenerator.getGroupLotto(amountLotto);
        output.printAmountLotto(groupLotto);

        // 당첨 번호 입력
        output.printInputWin();
        winLotto = input.inputWinNum();
        Lotto lotto = new Lotto(winLotto);

        // 보너스 번호 입력
        output.printInputBonus();
        bonusNum = input.inputBonus(lotto.getNumbers());

        // 당첨 통계
        output.printStatistics();
        lottoResult statistics = new lottoResult(groupLotto, winLotto, bonusNum);
        winResult = statistics.getWinResult();
        output.printWinResult(winResult);

        // 수익률
        calculateIncome calculateincome = new calculateIncome(winResult);
        output.printIncomeRate(calculateincome.getIncomeRate(amountLotto * 1000));
    }


}
