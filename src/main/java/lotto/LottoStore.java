package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoErrorMessage.*;
import static lotto.LottoConstant.*;

public class LottoStore {
    private List<Lotto> lottoTickets = new ArrayList<>();

    public void buyLottoNumber(int price) {
        validate(price);

        int lottoPurchaseCount = price / LOTTO_PRICE;
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < lottoPurchaseCount; i++) {
            Lotto lotto = new Lotto(lottoMachine.createNumbers());

            lottoTickets.add(lotto);
        }

        printLottoNumbers();
    }

    public List<Lotto> getLottoTickets(){
        return lottoTickets;
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
        int lottoPurchaseCount = lottoTickets.size();

        message.append(lottoPurchaseCount + BUY_MSG + "\n");

        for (int i = 0; i < lottoPurchaseCount; i++) {
            message.append(lottoTickets.get(i) + "\n");
        }

        System.out.println(message);
    }
}
