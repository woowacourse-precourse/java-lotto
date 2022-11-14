package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ErrorMessage;
import lotto.util.LottoConstant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Customer {

    public WinningNumber generateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public Lottos purchaseLottos(int money) {
        validateUnitOfTenThousand(money);
        return new Lottos(IntStream.range(0, getLottoCount(money))
                .mapToObj(index -> purchaseLotto())
                .collect(Collectors.toList()));
    }

    private int getLottoCount(int money) {
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

    private void validateUnitOfTenThousand(int money) {
        if (money % LottoConstant.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_OF_MONEY.getMessage());
        }
    }
}
