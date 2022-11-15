package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User inputUserData() {
        User user = new User(inputAmount());
        setUserLotto(user);
        printLottoNumbers(user);
        return user;
    }

    public int inputAmount() {
        outputView.askAmount();
        return inputView.inputAmount();
    }

    public void setUserLotto(User user) {
        outputView.showPurchaseQuantity(user);
        user.setAutoNumbers(getAmount(user));
    }

    public void printLottoNumbers(User user) {
        outputView.showUserLottoNumber(user);
    }

    public int getAmount(User user) {
        return user.getAmount();
    }
}