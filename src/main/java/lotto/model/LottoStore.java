package lotto.model;

import java.util.ArrayList;
import java.util.List;


public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoNumber(int price) {
        validatePrice(price);
        List<Lotto> lottoTickets = new ArrayList<>();
        int lottoPurchaseCount = price / LOTTO_PRICE;
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < lottoPurchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.createNumbers());

            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE) {
            Error.printException(ErrorType.PRICE);
            throw new IllegalArgumentException();
        }

        if (price % LOTTO_PRICE != 0) {
            Error.printException(ErrorType.PRICE);
            throw new IllegalArgumentException();
        }
    }
}
