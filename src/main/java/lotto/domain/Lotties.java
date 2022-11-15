package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotties {

    private final List<Lotto> lotties;

    private Lotties(int issueCount) {
        lotties = new ArrayList<>();
        addLottoToList(issueCount);
    }

    public static Lotties create(int issueCount) {
        return new Lotties(issueCount);
    }

    private void addLottoToList(int issueCount) {
        IntStream.range(0, issueCount)
                .forEach(x -> lotties.add(
                        new Lotto(LottoGenerator.createRandomLottoNumber())));
    }

    public Map<LottoRank, Long> generateLottoRankMap(List<Integer> userLotto, int bonusNum) {
        return lotties.stream()
                .map(lotto -> LottoRank.of(lotto.findLottoWinCount(userLotto),
                        lotto.hasBonusNumber(bonusNum)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int count() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }
}
