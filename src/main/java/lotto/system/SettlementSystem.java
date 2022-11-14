package lotto.system;

import java.util.Map;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;
import lotto.domain.score.Ranking;

public class SettlementSystem {
    private final static String MESSAGE_ALL_PROFITS = "총 수익률은 %.1f%%입니다.";
    private final static String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    private final static String MESSAGE_HYPHEN = "---";
    private static final String MESSAGE_AMOUNT = " - %d개";
    private final Map<Ranking, Integer> settlement;
    private final IoSystem io;

    public SettlementSystem(IoSystem ioSystem) {
        this.settlement = Ranking.generateList();
        this.io = ioSystem;
    }

    public void printCalculateProfits(Money money) {
        Money profits = calculateProfits();

        io.printBeforeNextLine(String.format(MESSAGE_ALL_PROFITS, money.calculateROI(profits)));
    }


    public void printSettlementResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        String result = settlementResult(lottoBundle, answerLotto);

        io.printBeforeNextLine(MESSAGE_WINNING_STATISTICS);
        io.printBeforeNextLine(MESSAGE_HYPHEN);
        io.printBeforeNextLine(result);
    }

    private Money calculateProfits() {
        var profits = Money.generateMoney(0L);

        for (var rankAdnCount : settlement.entrySet()) {
            profits = profits.plus(rankAdnCount.getKey()
                    .calculateProfits(rankAdnCount.getValue())
            );
        }
        
        return profits;
    }

    private String settlementResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        this.startRaffle(lottoBundle, answerLotto);

        StringBuilder stringBuilder = new StringBuilder();

        for (var rankAndCount : settlement.entrySet()) {
            var rankScoreResult = rankAndCount.getKey()
                    .result();
            var rankScoreCount = String.format(MESSAGE_AMOUNT, rankAndCount.getValue());

            stringBuilder.append(rankScoreResult)
                    .append(rankScoreCount);
        }

        return stringBuilder.toString()
                .trim();
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


}
