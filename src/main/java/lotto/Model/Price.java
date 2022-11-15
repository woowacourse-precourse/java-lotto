package lotto.Model;

import camp.nextstep.edu.missionutils.Console;
import lotto.Utils.Validator.PriceValidator;
import lotto.View.InputView;

public class Price {

    private final int inputPrice;
    private final int lottoTicketCount;
    private static final int ERROR_NUMBER=0;

    public Price() {
        InputView.buyLotto();
        this.inputPrice = inputPrice();
        this.lottoTicketCount = lottoTickets(inputPrice);
    }

    public int getInputPrice() {
        return inputPrice;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }



    public int lottoTickets(int price) {
        return price / 1000;
    }

    public static int inputPrice() {
        String priceInputs = Console.readLine();
        if (!PriceValidator.checkPriceInteger(priceInputs)) {
            return ERROR_NUMBER;
        }
        if(!PriceValidator.priceCorrect(Integer.parseInt(priceInputs))){
            return ERROR_NUMBER;
        }
        return Integer.parseInt(priceInputs);
    }


}
