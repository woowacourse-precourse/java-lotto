package lotto.domain;


import lotto.Lotto;
import static lotto.exception.ExceptionMessages.IndivisibleMoneyMessage;
import static lotto.exception.ExceptionMessages.InvalidMoneyMessage;
import static lotto.util.NumberParser.doubleToString;
import java.text.DecimalFormat;
import java.util.Map;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final int inputMoney;
    private final int purchasedLottoCount;
    private final Lottos lottos;
    private double profitPercent;

    public LottoMachine(int inputMoney) {
        validateMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.purchasedLottoCount = calculateLottoCount(inputMoney);
        lottos = new Lottos(purchasedLottoCount);
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.valueOf(IndivisibleMoneyMessage));
        }
        if (money < 0) {
            throw new IllegalArgumentException(String.valueOf(InvalidMoneyMessage));
        }
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public void checkLottosRank(Lotto winningLotto, int bonusNumber) {
        lottos.checkRankStatistic(winningLotto.getNumbers(), bonusNumber);
        updateProfitPercent();
    }

    private void updateProfitPercent() {
        profitPercent = countProfitPercent();
    }

    private double countProfitPercent() {
        double profit = countWinningMoney(lottos.getRankStatistic());
        return profit / (inputMoney) * 100;
    }

    private double countWinningMoney(Map<Rank, Integer> rankStatistic) {
        double profit = 0;
        for (Rank rank : rankStatistic.keySet()) {
            profit += rank.getWinningMoney() * rankStatistic.get(rank);
        }
        return profit;
    }

    public int getPurchasedLottoCnt() {
        return purchasedLottoCount;
    }

    public String lottosToString() {
        return lottos.lottosToString();
    }

    public String rankStatisticsToString() {
        StringBuilder sb = new StringBuilder();
        Map<Rank, Integer> rankStatistic = lottos.getRankStatistic();
        sb.append("당첨 통계").append("\n");
        sb.append("---").append("\n");
        addStringOfRank(sb, Rank.FIFTH, rankStatistic);
        addStringOfRank(sb, Rank.FOURTH, rankStatistic);
        addStringOfRank(sb, Rank.THIRD, rankStatistic);
        addStringOfRank(sb, Rank.SECOND, rankStatistic);
        addStringOfRank(sb, Rank.FIRST, rankStatistic);
        sb.append("총 수익률은 ").append(doubleToString(profitPercent)).append("%입니다.");
        return sb.toString();
    }

    private void addStringOfRank(StringBuilder sb, Rank rank, Map<Rank, Integer> rankStatistic) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        sb.append(rank.getCountOfMatch())
                .append("개 일치");
        if (rank.equals(Rank.SECOND)) {
            sb.append(", ")
                    .append("보너스 볼 일치");
        }
        sb.append(" (")
                .append(formatter.format(rank.getWinningMoney()))
                .append("원) - ")
                .append(rankStatistic.getOrDefault(rank, 0))
                .append("개")
                .append("\n");
    }
}
