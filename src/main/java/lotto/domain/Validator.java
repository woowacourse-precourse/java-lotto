package lotto.domain;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void duplicationCheck(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        if (numbers.size() != numbersWithoutDuplication.size()) {
            throw new IllegalArgumentException();
        }
    }


    public static void rangeCheck(List<Integer> numbers) {
        final int start = LottoConstants.START_NUMBER.getValue();
        final int end = LottoConstants.END_NUMBER.getValue();
        for (Integer number : numbers) {
            if (number < start || number > end) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int numberFormatCheck(String userInput) {
        int value;
        try {
            value = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static void multipleOfTicketPriceCheck(int money) {
        if (money % LottoConstants.TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] inputFormatCheck(String userInput) {
        String[] elements = userInput.split(",");
        if (elements.length != LottoConstants.LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
        return elements;
    }

    public static void containsCheck(int target, List<Integer> numbers) {
        if (numbers.contains(target)) {
            throw new IllegalArgumentException();
        }
    }
}
