package Util;

import camp.nextstep.edu.missionutils.Console;
import domain.ConstantNumber;
import lotto.Lotto;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static domain.ErrorMessage.*;
import static domain.InputMessage.*;

public class InputUtils {


    public int StringToMoney() {
        System.out.println(INPUT_BUY_MESSAGE.getMessage());
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    public void validateMoney(String input) {
        isNumber(input);
        isEnoughMoney(input);
    }

    private void isEnoughMoney(String input) {
        int money = Integer.parseInt(input);
        if (money % ConstantNumber.VALID_MONEY.getNumber() != 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR.getMessage());
        }
    }

    private void isNumber(String input) {
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }
    public Lotto StringToWinningLottoNumber(){
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE.getMessage());
        String WinningLottoNumber = Console.readLine();
        validateWinningLottoNumber(WinningLottoNumber);

        return new Lotto(
            Arrays.stream(WinningLottoNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
        );
    }

    public void validateWinningLottoNumber(String input){
        isLottoNumberStyle(input);
    }

    private void isLottoNumberStyle(String input){
        String regex = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if(!Pattern.matches(regex, input)){
            throw new IllegalArgumentException(NOT_WINNING_LOTTO_INPUT_STYLE_ERROR.getMessage());
        }
    }
}
