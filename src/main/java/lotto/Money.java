package lotto;

import io.Input;
import io.Output;
import io.Sentence;

public class Money {
    private static int lottoCnt;

    public static void InputMoneyForLotto(Input input, Output output) {
        String moneyInput = input.getInput(Sentence.INPUTMONEY.getValue(), output);
        validateMoneyInput(moneyInput);
        lottoCnt = getlottoCnt(moneyInput);
        //'구매 금액 입력해 주세요' 출력
    }

    public static int printHowManyLottos(Output output) {
        output.printOutput(String.format(Sentence.YOUPURCHASED.getValue(), lottoCnt));
        return lottoCnt;
        //'n장의 로또 구매했어요' 출력
    }

    private static void validateMoneyInput(String moneyInput) {
        checkDigits(moneyInput);
        checkDivideBy1000(moneyInput);
    }

    private static void checkDigits(String moneyInput) {
        long count = moneyInput.chars()
            .filter(Character::isDigit)
            .count();
        if (count != moneyInput.length()) {
            throw new IllegalArgumentException("Input money contains not money");
        }
    }

    private static void checkDivideBy1000(String moneyInput) {
        if (!moneyInput.substring(moneyInput.length() - 3, moneyInput.length()).equals("000")) {
            throw new IllegalArgumentException("Money not divided by 1000");
        }
    }

    private static int getlottoCnt(String moneyInput) {
        lottoCnt = Integer.parseInt(moneyInput.substring(0, moneyInput.length()-3));
        return lottoCnt;
    }
}

// 입력 금액이 유효한지 판단해 몇개의 로또를 사는지 계산한다.