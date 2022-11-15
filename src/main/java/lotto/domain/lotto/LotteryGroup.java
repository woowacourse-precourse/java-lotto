package lotto.domain.lotto;

import java.util.Map;
import lotto.domain.money.Money;
import lotto.domain.score.Ranking;

public class LotteryGroup {
    private static final String MESSAGE_AMOUNT = " - %d개";
    private Map<Ranking, Integer> calculateResult;

    public Money calculateProfits() {
        var profits = Money.generateZeroMoney();

        for (var entrySet : calculateResult.entrySet()) {
            var ranking = entrySet.getKey();
            var count = entrySet.getValue();

            profits = profits.plus(ranking.calculateProfits(count));
        }
        return profits;
    }

    public String settleResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        this.startRaffle(lottoBundle, answerLotto);

        var stringBuilder = new StringBuilder();
        for (var rankAndCount : calculateResult.entrySet()) {
            var ranking = rankAndCount.getKey();
            var count = rankAndCount.getValue();
            var rankScoreCount = String.format(MESSAGE_AMOUNT, count);
            stringBuilder.append(ranking.result())
                    .append(rankScoreCount)
                    .append("\n");
        }
        return stringBuilder.toString()
                .trim();
    }

    private void startRaffle(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        this.calculateResult = Ranking.generateList();

        for (var randomLotto : lottoBundle.getLottoBundle()) {
            var rank = answerLotto.compareLotto(randomLotto)
                    .generateRank();

            if (calculateResult.containsKey(rank)) {
                calculateResult.put(rank, calculateResult.get(rank) + 1);
            }
        }
    }

}
