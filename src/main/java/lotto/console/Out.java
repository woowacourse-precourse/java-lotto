package lotto.console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class Out {
    public static void printErrorMessage(Exception exception) {
        System.out.println("[ERROR]" + exception.getMessage());
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printResult(LottoResult result) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        for (LottoRank rank : result.getRanks().values()) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        List<LottoRank> ranksDesc = Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("###,###");

        builder.append("당첨 통계");
        builder.append(System.lineSeparator());
        builder.append("---");
        builder.append(System.lineSeparator());
        for (LottoRank rank : ranksDesc) {
            builder.append(rank.getMatch());
            builder.append("개 일치");
            if (rank.shouldBonusMatch()) {
                builder.append(", 보너스 볼 일치");
            }
            builder.append(" ");
            builder.append("(").append(formatter.format(rank.getPrize())).append("원) - ");
            builder.append(rankCount.getOrDefault(rank, 0)).append("개");
            builder.append(System.lineSeparator());
        }
        builder.append("총 수익률은 ").append(result.getEarningsRatio()).append("%입니다.");
        builder.append(System.lineSeparator());
        System.out.println(builder);
    }

}
