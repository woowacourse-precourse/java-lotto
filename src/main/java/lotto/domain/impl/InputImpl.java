package lotto.domain.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.PrizeNumber;
import lotto.domain.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;
import static lotto.Constants.COMMA;
import static lotto.message.ExceptionMessage.PRIZE_EXCEPTION;
import static lotto.message.ExceptionMessage.TYPE_EXCEPTION;
import static lotto.message.Message.*;

public class InputImpl implements Input {
    @Override
    public int amount() {
        System.out.println(REQUEST_AMOUNT);
        String input = Console.readLine();
        typeValidate(input);
        return Integer.parseInt(input);
    }

    @Override
    public PrizeNumber prizeNumber() {
        List<Integer> numbers = requestNumbers();
        int bonusNumber = requestBonusNumber();
        return new PrizeNumber(numbers, bonusNumber);
    }

    private List<Integer> requestNumbers() {
        System.out.println(REQUEST_PRIZE_NUMBERS);
        String input = Console.readLine();
        validate(input);

        return Arrays.stream(input.split(COMMA))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void validate(String input) {
        for (char ch : input.toCharArray()) {
            if (!isDigit(ch) && !COMMA.equals(String.valueOf(ch))) {
                throw new IllegalArgumentException(PRIZE_EXCEPTION);
            }
        }
    }

    private int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        typeValidate(input);
        return Integer.parseInt(input);
    }

    private void typeValidate(String target) {
        for (char ch : target.toCharArray()) {
            if (!isDigit(ch)) {
                throw new IllegalArgumentException(TYPE_EXCEPTION);
            }
        }
    }
}
