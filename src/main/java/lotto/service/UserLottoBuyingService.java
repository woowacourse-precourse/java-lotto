package lotto.service;

import lotto.domian.User;
import lotto.exception.UserInputLottoInfoException;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UserLottoBuyingService {

    UserInputLottoInfoException userInputLottoInfoException = new UserInputLottoInfoException();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public long userLottoBuyingPrice() {
        outputView.printBuyingPriceQuestion();
        String buyingPrice = inputView.inputUserLottoBuyingPrice();
        checkThisBuyingPriceIsValid(buyingPrice);
        return Long.parseLong(buyingPrice);
    }
}
