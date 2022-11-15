package lotto.view.output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String OUTPUT_LOTTOS_GUIDE = "%s개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_RESULT_GUIDE = "당첨 통계\n---";

    private final OutputViewFormatter outputViewFormatter;

    public OutputView() {
        this.outputViewFormatter = new OutputViewFormatter();
    }

    public void outputLottos(Lottos lottos) {
        System.out.println(String.format(OUTPUT_LOTTOS_GUIDE, lottos.count()));
        System.out.println(String.join(NEW_LINE, lottoOutputTexts(lottos)));
        printEnter();
    }

    private List<String> lottoOutputTexts(Lottos lottos) {
        return lottos.lottos().stream()
                .map(outputViewFormatter::outputLottoFormat)
                .collect(Collectors.toList());
    }

    public void outputLottoResult(LottoResult lottoResult) {
        System.out.println(OUTPUT_LOTTO_RESULT_GUIDE);
        String result = Arrays.stream(sortRankByReward())
                .filter(rank -> rank != Rank.MISS)
                .map(rank -> outputViewFormatter.outputRankFormat(rank, lottoResult.rankCount(rank)))
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(result);
    }

    private static Rank[] sortRankByReward() {
        Rank[] ranks = Rank.values();
        Arrays.sort(ranks, (o1, o2) -> Long.valueOf(o1.reward().value() - o2.reward().value()).intValue());
        return ranks;
    }

    public void outputYield(Money investmentPrincipal, Money revenue) {
        System.out.println(outputViewFormatter.outputYieldFormat(Money.yield(investmentPrincipal, revenue)));
    }

    private static void printEnter() {
        System.out.println();
    }

    public void outputException(Exception exception) {
        System.out.println(outputViewFormatter.outputExceptionFormat(exception));
    }
}
