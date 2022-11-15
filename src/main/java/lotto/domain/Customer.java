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

    public Lottos purchaseLottos(int purchaseMoney) {
        validateUnitOfTenThousand(purchaseMoney);
        return new Lottos(IntStream.range(0, getLottoCount(purchaseMoney))
                .mapToObj(index -> purchaseLotto())
                .collect(Collectors.toList()));
    }

    public Lotto purchaseLotto() {
        return new Lotto(generateLottoNumbers());
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.START_NUMBER.getValue(),
                LottoConstant.END_NUMBER.getValue(),
                LottoConstant.NUMBER_COUNT.getValue());
    }

    private int getLottoCount(int purchaseMoney) {
        return purchaseMoney / LottoConstant.PRICE.getValue();
    }

    private void validateUnitOfTenThousand(int money) {
        if (money % LottoConstant.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_OF_MONEY.getMessage());
        }
    }
}
