package lotto;

import camp.nextstep.edu.missionutils.Console;

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
