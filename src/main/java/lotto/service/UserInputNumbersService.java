package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserInputNumbersService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public User inputUserNumbers() {
        outputView.printAskBuyingLottoPriceMessage();
        String price = inputView.askInputLottoBuyingPrice();
        User user = new User(parsingPrice(price));
        outputView.printBuyingLottoQuantityMessage(user);
        user.setLottosCount(getUserBuyingLottoPrice(user) / 1000);
        outputView.printUserLottoNumbers(user);
        return user;
    }



}
