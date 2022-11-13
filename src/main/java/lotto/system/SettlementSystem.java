package lotto.system;

import java.util.Map;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;
import lotto.domain.score.Ranking;

public class SettlementSystem {
    private final Map<Ranking, Integer> settlement;

    public SettlementSystem() {
        this.settlement = Ranking.generateList();
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

    public String result(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        this.startRaffle(lottoBundle, answerLotto);

        StringBuilder stringBuilder = new StringBuilder();

        for (var rankAndCount : settlement.entrySet()) {
            stringBuilder.append(rankAndCount.getKey().result())
                    .append("- ")
                    .append(rankAndCount.getValue())
                    .append("개")
                    .append("\n");

        }
        return stringBuilder.toString().trim();
    }

    public Money calculateProfits() {
        var profits = Money.zero();
        for (var rankAdnCount : settlement.entrySet()) {
            profits = profits.plus(rankAdnCount.getKey()
                    .calculateProfits(rankAdnCount.getValue())
            );
        }
        return profits;
    }
}
