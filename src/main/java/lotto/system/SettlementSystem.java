package lotto.system;

import java.util.Map;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;
import lotto.domain.score.Ranking;

public class SettlementSystem {
    private final Map<Ranking, Integer> settlement;
    private final IoSystem io;

    public SettlementSystem(IoSystem ioSystem) {
        this.settlement = Ranking.generateList();
        this.io = ioSystem;
    }

    public void printCalculateProfits(Money money) {
        var profits = Money.generateMoney(0L);

        for (var rankAdnCount : settlement.entrySet()) {
            profits = profits.plus(rankAdnCount.getKey()
                    .calculateProfits(rankAdnCount.getValue())
            );
        }

        io.printBeforeNextLine(String.format("총 수익률은 %.1f%%입니다.", money.calculateROI(profits)));
    }

    private void startRaffle(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        for (var randomLotto : lottoBundle.getLottoBundle()) {
            var rank = answerLotto.compareLotto(randomLotto)
                    .generateRank();
            if (settlement.containsKey(rank)) {
                settlement.put(rank, settlement.get(rank) + 1);
            }
        }
    }

    public void printSettlementResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        this.startRaffle(lottoBundle, answerLotto);

        StringBuilder stringBuilder = new StringBuilder();

        for (var rankAndCount : settlement.entrySet()) {
            stringBuilder.append(rankAndCount.getKey().result())
                    .append(String.format(" - %d개\n", rankAndCount.getValue()));
        }

        var result = stringBuilder.toString().trim();

        io.printBeforeNextLine("당첨 통계");
        io.printBeforeNextLine("---");
        io.printBeforeNextLine(result);
    }
}
