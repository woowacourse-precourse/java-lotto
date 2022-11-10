package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final String PRICE_ERROR_MSG = "[ERROR] 1000원 단위로 입력해주세요";
    private static final String BUY_MSG = "개를 구매했습니다.";
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoNumbers = new ArrayList<>();

    public void buyLottoNumber(int price) {
        validate(price);

        int lottoPurchaseCount = price / LOTTO_PRICE;
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < lottoPurchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.create());

            lottoNumbers.add(lotto);
        }

        printLottoNumbers();
    }

    private void validate(int price) {
        if (price < LOTTO_PRICE) {
            System.out.println(PRICE_ERROR_MSG);
            throw new IllegalArgumentException();
        }

        if (price % LOTTO_PRICE != 0) {
            System.out.println(PRICE_ERROR_MSG);
            throw new IllegalArgumentException();
        }
    }

    private void printLottoNumbers() {
        StringBuilder message = new StringBuilder();
        int lottoPurchaseCount = lottoNumbers.size();

        message.append(lottoPurchaseCount + BUY_MSG + "\n");

        for (int i = 0; i < lottoPurchaseCount; i++) {
            message.append(lottoNumbers.get(i) + "\n");
        }

        System.out.println(message);
    }
}
