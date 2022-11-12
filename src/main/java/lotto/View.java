package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    public void printAmountInput() {
        System.out.println(GameConstant.START.getValue());
    }

    public int getAmount() {
        String input;

        input = Console.readLine();

        try {
            validateAmountInput(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

        return Integer.parseInt(input);
    }

    public void printNumberOfLotto(int number) {
        System.out.println(number + GameConstant.NUMBER_OF_GAME.getValue());
    }

    public void printEachLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printGetWinningNumber() {
        System.out.println(GameConstant.GET_WINNING_NUMBER.getValue());
    }

    public void printGetBonusNumber() {
        System.out.println(GameConstant.GET_BONUS_NUMBER.getValue());
    }

    public List<Integer> getWinningNumber() {
        List<Integer> winningNumber;
        String[] commaSeparate;
        String input;

        input = Console.readLine();
        commaSeparate = input.split(",");
        validateWinningNumber(Arrays.asList(commaSeparate));

        winningNumber = Arrays.asList(commaSeparate)
                .stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return winningNumber;
    }

    public int getBonusNumber() {
        String number;

        number = Console.readLine();
        validateBonusNumber(number);

        return Integer.parseInt(number);
    }

    public void validateAmountInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (isDivisible(input)) {
            throw new IllegalArgumentException(GameConstant.DIVISIBLE_EXCEPTION.getValue());
        }
    }

    public void validateWinningNumber(List<String> numbers) {
        for (String element : numbers) {
            if (!isInteger(element)) {
                throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
            }

            if (checkBoundary(element)) {
                throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
            }
        }
    }

    public void validateBonusNumber(String number) {
        if (!isInteger(number)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (checkBoundary(number)) {
            throw new IllegalArgumentException(GameConstant.BOUNDARY_EXCEPTION.getValue());
        }
    }

    public boolean checkBoundary(String input) {
        return Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45;
    }

    public boolean isDivisible(String input) {
        return (Integer.parseInt(input) % 1000 != 0);
    }

    public boolean isInteger(String input) {
        return input.matches("[0-9.]+");
    }

}
