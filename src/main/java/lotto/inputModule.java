package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class inputModule {
    public static final String ErrorMessage_InputNumber = "[ERROR] 금액을 정확히 입력해 주세요.";
    public static final String ErrorMessage_NumberForm = "[ERROR] 로또 번호를 정확히 입력해 주세요.";
    public static final String ErrorMessage_BonusNumber = "[ERROR] 보너스 번호를 정확히 입력해 주세요.";

    public static int inputPurchaseAmount() {
        return (inputOnlyNumber());
    }

    private static int inputOnlyNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage_InputNumber);
        }
    }

    public static List<Integer> inputLuckyNumbers() {
        try {
            String luckyNumbers = Console.readLine();
            String[] cutLuckyNumbers = luckyNumbers.split(",");
            return alterInteger(cutLuckyNumbers);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage_NumberForm);
        }
    }

    private static List<Integer> alterInteger(String[] split) {
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return (inputOneNumber());
    }

    private static int inputOneNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage_BonusNumber);
        }
    }
}