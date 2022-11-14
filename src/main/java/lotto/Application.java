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
            OutOfDigitException(amount);

            LottoList userLotto = new LottoList(new BigInteger(amount));
            PrintGameInfo.purchaseCount(userLotto.getLottoCount());

        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }

    public static void OutOfDigitException(String amount) {
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
}
