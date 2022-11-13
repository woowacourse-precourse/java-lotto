package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {
    private static final String NEW_LINE = "\n";

    private final OutputViewFormatter outputViewFormatter;

    public OutputView() {
        this.outputViewFormatter = new OutputViewFormatter();
    }

    public void outputLottos(Lottos lottos) {
        for (String lottoOutput : lottoOutputTexts(lottos)) {
            System.out.println(lottoOutput);
        }
    }

    private List<String> lottoOutputTexts(Lottos lottos) {
        return lottos.lottos().stream()
                .map(outputViewFormatter::outputLottoFormat)
                .collect(Collectors.toList());
    }

    public void outputLottoResult(LottoResult lottoResult) {
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
}
