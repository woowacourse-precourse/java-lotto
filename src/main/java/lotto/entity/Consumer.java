package lotto.entity;

import static lotto.entity.LottoConstant.COUNT;
import static lotto.entity.LottoConstant.PRICE;
import static lotto.entity.LottoConstant.RANGE_END;
import static lotto.entity.LottoConstant.RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Consumer {

    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Consumer(int purchaseAmount) {
        if (purchaseAmount % COUNT.getValue() != 0) {
            throw new IllegalArgumentException(
                "금액은 " + PRICE.getValue() + "원 단위로 입력해야 합니다. 입력 : " + purchaseAmount);
        }
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos();
    }

    private List<Lotto> generateLottos() {
        return IntStream.range(0, purchaseAmount / PRICE.getValue())
            .mapToObj(
                i -> new Lotto(
                    Randoms.pickUniqueNumbersInRange(RANGE_START.getValue(), RANGE_END.getValue(),
                        COUNT.getValue())))
            .collect(Collectors.toList());
    }

    public Result confirmResultOfLottos(WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResultOfLottos();
        lottos.stream()
            .map(winningLotto::compare)
            .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));
        return new Result(result, purchaseAmount);
    }

    private Map<Rank, Integer> initResultOfLottos() {
        Map<Rank, Integer> result = new TreeMap<>(new Comparator<Rank>() {
            @Override
            public int compare(Rank rank1, Rank rank2) {
                return rank1.getPrize() - rank2.getPrize();
            }
        });
        Arrays.stream(Rank.values())
            .forEach(rank -> result.put(rank, 0));
        return result;
    }

}
