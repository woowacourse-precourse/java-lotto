package lotto.service;

import lotto.domian.User;
import lotto.exception.UserInputLottoInfoException;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UserLottoBuyingService {
    UserInputLottoInfoException userInputLottoInfoException = new UserInputLottoInfoException();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public User setUserInfo() {
        User user = new User(userLottoBuyingPrice());
        setUserTotalLotto(user);
        printUserLottoNumbers(user);
        return user;
    }
    public long userLottoBuyingPrice() {
        outputView.printBuyingPriceQuestion();
        String buyingPrice = inputView.inputUserLottoBuyingPrice();
        checkThisBuyingPriceIsValid(buyingPrice);
        return Long.parseLong(buyingPrice);
    }
    public void checkThisBuyingPriceIsValid(String buyingPrice) {
        userInputLottoInfoException.checkInputIsEmpty(buyingPrice, "입력이 null 입니다. 금액을 입력해주세요");
        userInputLottoInfoException.verifyExistBlank(buyingPrice, "금액 입력 값으로 공백이 있습니다.");
        userInputLottoInfoException.isInputValueOnlyNumber(buyingPrice,"금액 입력 값으로는 숫자만 가능합니다.");
        userInputLottoInfoException.isDividedByThousand(buyingPrice, "입력 금액의 최소 단위는 천원입니다.");
    }
    public void setUserTotalLotto(User user) {
        outputView.printUserLottoQuantity(user.getUserLottoQuantity());
        user.createLottoNumbers(user.getUserLottoQuantity());
    }
    public void printUserLottoNumbers(User user) {
        outputView.printUserLottoNumbers(user);
    }
}
