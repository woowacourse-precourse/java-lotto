package lotto.domain;

import java.util.List;

public class Player {
    private final long payment;
    private final long lottoCount;
    private final List<List<Integer>> lottoPapers;
    final long WON_UNIT = 1000L;

    public Player(long money) {
        validateWonUnit(money);
        this.payment = money;
        this.lottoCount = money / WON_UNIT;
        this.lottoPapers = LottoStore.saleLotto(lottoCount);
    }

    private void validateWonUnit(long money) {
        String WON_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위만 가능합니다.";

        if (money % WON_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException(WON_UNIT_ERROR_MESSAGE);
        }
    }

    public long getPayment() {
        return payment;
    }

    public long getLottoCount() {
        return lottoCount;
    }

    public List<List<Integer>> getLottoPapers() {
        return lottoPapers;
    }
}
