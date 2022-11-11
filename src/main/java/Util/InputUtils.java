package Util;

import camp.nextstep.edu.missionutils.Console;
import domain.Validate;
import lotto.Lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

import static Util.UiMessage.inputBuyMessage;


public class InputUtils {

    private final static Validate validate = new Validate();

    public static int StringToMoney() {
        inputBuyMessage();
        String money = Console.readLine();
        validate.validateMoney(money);
        return Integer.parseInt(money);
    }

    public static Lotto StringToWinningLottoNumber(){
        UiMessage.inputWinningLottoNumberMessage();
        String WinningLottoNumber = Console.readLine();
        validate.validateWinningLottoNumber(WinningLottoNumber);

        return new Lotto(
            Arrays.stream(WinningLottoNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
        );
    }
}
