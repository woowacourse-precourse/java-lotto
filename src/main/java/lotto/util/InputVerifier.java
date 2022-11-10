package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.view.View;

public class InputVerifier {

    public static void checkMoney(String input) {
        if (!isInteger(input)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (!isLottoPrice(input)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }
    }

    public static void checkLottoNumber(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            if (!isInteger(lottoNumber)) {
                View.printNotInteger();
                throw new IllegalArgumentException();
            }
        }

        if (!isValidSize(lottoNumbers)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }

        if (!isValidNumbers(lottoNumbers)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }

        if (!isUniqueNumber(lottoNumbers)) {
            View.printNotUniqueNumber();
            throw new IllegalArgumentException();
        }
    }

    public static void checkBonusNumber(String BonusNumber) {
        if (!isInteger(BonusNumber)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (BonusNumber.length() != Constant.BONUS_NUMBER_SIZE) {
            //TODO: 에러메시지 생성 필요
            throw new IllegalArgumentException();
        }

        if (!isValidNumber(BonusNumber)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            char needVerify = input.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLottoPrice(String input) {
        int number = Integer.parseInt(input);
        return number % Constant.LOTTO_PRICE == 0;
    }

    // TODO: 쉼표로 구분했는지 검증하는 기능 구현 필요

    private static boolean isValidSize(List<String> input) {
        return input.size() == 6;
    }

    private static boolean isValidNumbers(List<String> input) {
        for (String i : input) {
            int number = Integer.parseInt(i);

            if (number < Constant.LOTTO_START_NUMBER || number > Constant.LOTTO_END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidNumber(String input) {
        int number = Integer.parseInt(input);

        return number >= Constant.LOTTO_START_NUMBER && number <= Constant.LOTTO_END_NUMBER;
    }

    private static boolean isUniqueNumber(List<String> input) {
        Set<String> uniqueInput = new HashSet<>(input);
        return uniqueInput.size() == input.size();
    }

}
