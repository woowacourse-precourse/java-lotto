package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User inputUserData() {
        int buyingPrice = inputBuyingPrice();
        User user = new User(buyingPrice);
        setUserLotto(user);
        printLottoNumbers(user);
        return user;
    }

    public int inputBuyingPrice() {
        outputView.askBuyingPriceView();
        int buyingPrice = inputView.inputBuyingPriceView();
        return buyingPrice;
    }

    public void setUserLotto(User user) {
        outputView.responseBuyingQuantity(user);
        user.setLottos(getBuyingPrice(user));
    }

    public void printLottoNumbers(User user) {
        outputView.responseUserLottoNumber(user);
    }

    public int getBuyingPrice(User user) {
        return user.getBuyingPrice();
    }
}
