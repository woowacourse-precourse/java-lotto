package lotto;

import java.util.List;
import java.util.Map;
import lotto.console.In;
import lotto.console.Out;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankCalculator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        try {
            Integer amount = In.readPaymentAmount();
            LottoGenerator generator = LottoGenerator.getInstance();
            Lottos lottos = generator.generateLottos(amount);
            Out.printLottos(lottos);

            List<Integer> mainDraw = In.readMainDraw();
            Integer bonus = In.readBonus();
            WinningNumbers winningNumbers = new WinningNumbers(mainDraw, bonus);

            Map<Lotto, LottoRank> ranks = LottoRankCalculator.calculateRanks(winningNumbers, lottos);
            LottoResult result = new LottoResult(ranks);
            Out.printResult(result);
        } catch (IllegalArgumentException e) {
            Out.printErrorMessage(e);
        }
    }
}
