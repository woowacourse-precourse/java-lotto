package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final String AMOUNT_IS_NOT_UNDER_1000_MESSAGE = "[ERROR] 로또 구입 금액이 1,000원 미만이 될 수 없습니다.";
    public static final int LOTTO_PER_PRICE = 1000;

    private int lottoCount;

    public LottoMachine() {
    }

    public int insert(int money) {
        validateAmountIsNotUnder1000(money);
        lottoCount = money / LOTTO_PER_PRICE;
        return lottoCount;
    }

    public List<Lotto> makeLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(AutoLottoGenerator.generate());
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void validateAmountIsNotUnder1000(int amount) {
        if (amount < LOTTO_PER_PRICE) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_UNDER_1000_MESSAGE);
        }
    }
}