package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MSG = "1000원 단위로 입력해주세요";

    private List<Lotto> lottoNumbers;

    public LottoStore(int price) {
        validate(price);

        lottoNumbers = new ArrayList<>();
    }

    private void validate(int price) {
        if (price < LOTTO_PRICE) {
            System.out.println(ERROR_MSG);
            throw new IllegalArgumentException();
        }

        if (price % LOTTO_PRICE != 0) {
            System.out.println(ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }
}
