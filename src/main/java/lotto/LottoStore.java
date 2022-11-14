package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoErrorMessage.*;
import static lotto.LottoConstant.*;
import static lotto.LottoSeller.printMessage;

public class LottoStore {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public List<Lotto> buyLottoNumber(int price) {
        validatePrice(price);
        int lottoPurchaseCount = price / LOTTO_PRICE;
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < lottoPurchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.createNumbers());

            lottoTickets.add(lotto);
        }

        printLottoNumbers();

        return lottoTickets;
    }

    private void validatePrice(int price) {
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
        int lottoPurchaseCount = lottoTickets.size();

        printMessage(String.format(BUY_MSG, lottoPurchaseCount));

        for (int i = 0; i < lottoPurchaseCount; i++) {
            printMessage(lottoTickets.get(i).toString());
        }
    }
}
