package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserException;

public class InputView {
    private final UserException userException = new UserException();

    public String askInputLottoBuyingPrice() {
        String lottoBuyingPrice = Console.readLine();
        userException.checkUserExceptions(lottoBuyingPrice);
        return lottoBuyingPrice;
    }


}
