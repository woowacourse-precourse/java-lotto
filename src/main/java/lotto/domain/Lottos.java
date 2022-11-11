package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoPriceException;
import lotto.view.InputView;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;
    private static final String QUANTITY_NOTIFICATION_MESSAGE = "개를 구매했습니다.\n";

    private Integer quantity;

    private List<Lotto> lottoNumbers;

    public Lottos() {
        this.quantity = countLottoQuantityByInputPrice();
        this.lottoNumbers = generateLottoNumbersByQuantity();
    }

    public Integer countLottoQuantityByInputPrice() {
        String price = InputView.lottoPriceInput();
        LottoPriceException.checkLottoPrice(price);
        return Integer.parseInt(price) / LOTTO_PRICE;
    }

    public List<Lotto> generateLottoNumbersByQuantity() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < this.quantity; i++) {
            lottoNumbers.add(new Lotto(LottoGenerator.generateLottoNumbers()));
        }
        return lottoNumbers;
    }

    @Override
    public String toString() {
        String quantityMessage = this.quantity + QUANTITY_NOTIFICATION_MESSAGE;
        String numbersString = lottoNumbers.toString();
        return quantityMessage + numbersString.substring(1, numbersString.length() - 1).replace("], [", "]\n[");
    }
}
