package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static int inputPrice() {
        System.out.println(InputMessage.NOTICE_INPUT_PRICE.getMessage());
        return getIntPrice();
    }

    private static void validatePrice(final String price) throws IllegalArgumentException {
        if (price.length() < 4) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
        }
        for (int i = 0; i < price.length(); ++i) {
            if (!('0' <= price.charAt(i) && price.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
            }
        }
        if (price.charAt(0) == '0' || Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
        }
    }

    private static int getIntPrice() {
        String price = Console.readLine();
        validatePrice(price);
        return Integer.parseInt(price);
    }

    public static List<Integer> inputWinningNumber() throws IllegalArgumentException {
        System.out.println(System.lineSeparator() + InputMessage.NOTICE_INPUT_WINNING_NUMBER.getMessage());
        return convertStringToIntegerList(Console.readLine());
    }

    private static List<Integer> convertStringToIntegerList(String winningNumber) throws IllegalArgumentException {
        try {
            return Arrays.stream(winningNumber.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_INPUT_WINNING_NUMBER.getMessage());
        }
    }

    public static List<Integer> inputBonusNumber() {
        System.out.println(System.lineSeparator() + InputMessage.NOTICE_INPUT_BONUS_NUMBER.getMessage());
        return convertStringToIntegerList(Console.readLine());
    }
}