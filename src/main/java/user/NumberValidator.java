package user;

import camp.nextstep.edu.missionutils.Console;
import ui.View;
import ui.ErrorConstant;

public class NumberValidator {
    public static void validateMoney(String input) {
        validateInputExist(input);
        validateMoneyStartWithZero(input);
        validateMoneyComponent(input);
        validateMoneySize(input);
        validateMoneyThousandDivide(input);
    }

    public static void validateLottoNumber(String input) {
        validateInputExist(input);
        validateLottoNumberStartWithZero(input);
        validateLottoNumberComponent(input);
        validateLottoNumberRange(input);
    }

    public static void validateWinningLotto(String input) {
        validateInputExist(input);
        int commaCount = 0;
        int calculate = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                commaCount++;
                validateWinningLottoRange(calculate);
                calculate = 0;
                continue;
            }
            validateWinningLottoComponent(input.charAt(i));
            if(calculate == 0 && input.charAt(i) == '0'){
                validateLottoNumberStartWithZero("0");
            }
            calculate += calculate * 10 + input.charAt(i) - '0';
        }
        validateWinningLottoComma(commaCount);
    }

    public static void validateInputExist(String input) {
        vaildateInputNotNull(input);
        vaildateInputNotBlank(input);
    }

    public static void vaildateInputNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorConstant.INPUT_NOT_NULL);
        }
    }

    public static void vaildateInputNotBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstant.INPUT_NOT_BLANK);
        }
    }

    public static void validateMoneyStartWithZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ErrorConstant.MONEY_FIRST_NOT_ZERO);
        }
    }

    public static void validateMoneyComponent(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(ErrorConstant.MONEY_MUST_NUMBER);
            }
        }
    }

    public static void validateMoneySize(String input) {
        if (input.length() < 4) {
            throw new IllegalArgumentException(ErrorConstant.MONEY_MORE_THAN_1000);
        }
    }

    public static void validateMoneyThousandDivide(String input) {
        for (int i = input.length() - 1, j = 0; j < 3; j++, i--) {
            if (input.charAt(i) != '0') {
                throw new IllegalArgumentException(ErrorConstant.MONEY_NOT_DIVIDE_1000);
            }
        }
    }

    public static void validateLottoNumberStartWithZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_FIRST_NOT_ZERO);
        }
    }

    public static void validateLottoNumberComponent(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_MUST_NUMBER);
            }
        }
    }

    public static void validateLottoNumberRange(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_OUT_RANGE);
        } else if (input.length() == 2 && input.charAt(0) == '4') {
            if (input.charAt(1) < '0' || input.charAt(1) > '5') {
                throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_OUT_RANGE);
            }
        } else if (input.length() == 2) {
            if (input.charAt(0) < '0' || input.charAt(0) > '3') {
                throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_OUT_RANGE);
            }
        }
    }

    public static void validateWinningLottoComma(int commaCount) {
        if (commaCount != 5) {
            throw new IllegalArgumentException(ErrorConstant.WINNING_LOTTO_COMMA);
        }
    }

    public static void validateWinningLottoComponent(char component) {
        if (component < '0' || component > '9') {
            throw new IllegalArgumentException(ErrorConstant.WINNING_LOTTO_COMPONENT);
        }
    }

    public static void validateWinningLottoRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorConstant.WINNING_LOTTO_OUT_RANGE);
        }
    }
    public static String myInput(){
        try{
            return Console.readLine();
        } catch(Exception e){
            return "";
        }
    }

    public static long makeMoney() {
        View.promptSeedMoney();
        String input = myInput();
        validateMoney(input);
        return Long.parseLong(input);
    }

    public static int makeLottoNumber() {
        View.promptBonusNumber();
        String input = myInput();
        validateLottoNumber(input);
        return Integer.parseInt(input);
    }
    public static String makeLotto(){
        View.promptWinningNumber();
        String input = myInput();
        validateWinningLotto(input);
        return input;
    }
}
