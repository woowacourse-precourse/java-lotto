package lotto.entity;

import static lotto.entity.LottoConstant.COUNT;
import static lotto.entity.LottoConstant.PRICE;
import static lotto.entity.LottoConstant.RANGE_END;
import static lotto.entity.LottoConstant.RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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

}
