package lotto;

import lotto.UI.View;
import lotto.domain.Calculator;
import lotto.domain.Judgment;
import lotto.domain.LottoGenerator;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Calculator calculator = new Calculator();

        // 입력 파트
        int investmentCash = view.getInvestmentCash();
        int myLottosNumber = calculator.countPublicationLotto(investmentCash);
        List<Lotto> myLottos = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < myLottosNumber; i++) {
            List<Integer> lottoNumber = lottoGenerator.createLottoNumber();
            myLottos.add(new Lotto(lottoNumber));
        }

        view.printMyLottoInfo(myLottos);

        Lotto winningLotto = new Lotto(view.getWinningNumber());
        int bonusNumber = view.getBonusNumber();

        // 계산 파트
        HashMap<Prize, Integer> state = new HashMap<>();
        state.put(Prize.FIRST, 0);
        state.put(Prize.SECOND, 0);
        state.put(Prize.THIRD, 0);
        state.put(Prize.FOURTH, 0);
        state.put(Prize.FIFTH, 0);

        int totalPrize = 0;
        for (Lotto lotto : myLottos) {
            Judgment judgment = new Judgment();
            int matchNumber = judgment.compare(winningLotto.getNumbers(), lotto.getNumbers());
            boolean bonus = judgment.hasBonusNumber(winningLotto.getNumbers(), bonusNumber);
            Prize prize = calculator.givePrize(matchNumber, bonus);

            if (prize != Prize.LAST) {
                int point = state.get(prize);
                state.replace(prize, point + 1);

                totalPrize += prize.getPrize();
            }
        }

        double profit = calculator.getProfit(totalPrize, investmentCash);
        //결과
        view.printResult(state, profit);
    }
}
