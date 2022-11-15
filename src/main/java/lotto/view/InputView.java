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

    public String askInputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    public String askInputLottoLuckyNumbers() {
        String LuckyLottoNumbers = Console.readLine();
        return LuckyLottoNumbers;
    }
}
