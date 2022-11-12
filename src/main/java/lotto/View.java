package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {

    public void printAmountInput() {
        System.out.println(GameConstant.START.getValue());
    }

    public int getAmount() {
        String input;

        input = Console.readLine();

        try {
            validateInput(input);
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

    public void validateInput(String input) {
        if (isInteger(input)) {
            throw new IllegalArgumentException(GameConstant.TYPE_EXCEPTION.getValue());
        }

        if (isDivisible(input)) {
            throw new IllegalArgumentException(GameConstant.DIVISIBLE_EXCEPTION.getValue());
        }

    }

    public boolean isDivisible(String input) {
        return (Integer.parseInt(input) % 1000 != 0);
    }

    public boolean isInteger(String input) {
        char[] element = input.toCharArray();
        int index;

        for (index = 0; index < element.length; index++) {
            if (element[index] < 48 || element[index] > 57) {
                return true;
            }
        }

        return false;
    }

}
