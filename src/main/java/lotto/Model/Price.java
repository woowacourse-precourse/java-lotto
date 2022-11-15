package lotto.Model;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.Validator.IntegerValidator;
import lotto.Utils.Validator.Number.PriceValidator;
import lotto.View.InputView;

public class Price {

    private final int inputPrice;
    private final int lottoTicketCount;
    private final static int ERROR_PRICE=0;

    public Price() {
        this.inputPrice = inputPrice();
        this.lottoTicketCount = LottoTickets(inputPrice);
    }

    public int getInputPrice() {
        return inputPrice;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }


    public int inputPrice() {
        InputView.buyLotto();
        String price = Console.readLine();
        PriceValidator.checkPrice(price);
        return Integer.parseInt(price);
    }

    public int LottoTickets(int price) {
        PriceValidator.price(price);
        return price / 1000;
    }


}
