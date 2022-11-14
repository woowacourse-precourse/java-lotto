package lotto;

import Info.PrintGameInfo;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintGameInfo.purchaseAmountInfo();

        try {
            String amount = Console.readLine();
            amountEmptyException(amount);
            outOfDigitException(amount);
            LottoList userLotto = new LottoList(new BigInteger(amount));


            PrintGameInfo.purchaseCount(userLotto.getLottoCount());

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }

    public static void outOfDigitException(String amount) {
        amount.chars().forEach(amountIndex -> {
            if (!Character.isDigit(amountIndex)) {
                throw new IllegalArgumentException(PrintGameInfo.getIsNotDigitString());
            }
        });
    }

    public static void amountEmptyException(String amount) {
        if (amount == null || amount.isEmpty() || amount.isBlank()) {
            throw new IllegalArgumentException(PrintGameInfo.getIsEmptyString());
        }
    }

    /**
     * 미사용 : 0원에 대해서 예외처리 할지 추후 결정
     * @param amount
     */
    public static void userInputZeroException(String amount) {
        if (checkAllZero(amount)) {
            throw new IllegalArgumentException(PrintGameInfo.USER_INPUT_ZERO);
        }
    }
    public static boolean checkAllZero(String amount) {
        boolean allZero = false;
        for (char digit : amount.toCharArray()) {
            if (PrintGameInfo.ZERO != digit) {
                return false;
            }
        }
        return true;
    }
}
