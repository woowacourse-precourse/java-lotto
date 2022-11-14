package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoConstant;
import lotto.util.LottoRank;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Customer {

    public WinningNumber generateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public Lottos purchaseLottos(int money) {
        return new Lottos(IntStream.range(0, getLottoCount(money))
                .mapToObj(index -> purchaseLotto())
                .collect(Collectors.toList()));
    }

    public int getLottoCount(int money) {
        return money / LottoConstant.PRICE.getValue();
    }

    private Lotto purchaseLotto() {
        return new Lotto(generateLottoNumber());
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.START_NUMBER.getValue(),
                LottoConstant.END_NUMBER.getValue(),
                LottoConstant.NUMBER_COUNT.getValue());
    }

}
