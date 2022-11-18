package lotto.view;

import static lotto.util.InputUtil.toIntStringNumberParser;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.UserBuyingException;

public class InputView {
    private final UserBuyingException userBuyingException = new UserBuyingException();

    public int inputBuyingPriceView() {
        try {
            String buyingPrice = Console.readLine();
            userBuyingException.validateBuyingException(buyingPrice);
            return toIntStringNumberParser(buyingPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    public String inputLottoNumbersView() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String inputBonusNumberView() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
