package lotto.domain;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String SIZE_ERROR_MESSAGE = "로또 번호는 6자리여야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "로또 번호는 중복이 없어야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "값은 정수형이어야 합니다.";
    private static final String MULTIPLE_OF_PRICE_ERROR_MESSAGE = "구입 금액은 가격의 배수여야 합니다.";
    private static final String INPUT_FORMAT_ERROR_MESSAGE = ",로 구분되는 6개의 숫자여야 합니다.";
    private static final String CONTAINS_ERROR_MESSAGE = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LENGTH) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public static void duplicationCheck(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        if (numbers.size() != numbersWithoutDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }


    public static void rangeCheck(List<Integer> numbers) {
        final int start = LottoConstants.START_NUMBER;
        final int end = LottoConstants.END_NUMBER;
        for (Integer number : numbers) {
            if (number < start || number > end) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static int numberFormatCheck(String userInput) throws IllegalArgumentException {
        int value;
        try {
            value = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
        return value;
    }

    public static void multipleOfTicketPriceCheck(int money) {
        if (money % LottoConstants.TICKET_PRICE != 0) {
            throw new IllegalArgumentException(MULTIPLE_OF_PRICE_ERROR_MESSAGE);
        }
    }

    public static String[] inputFormatCheck(String userInput) {
        String[] elements = userInput.split(",");
        if (elements.length != LottoConstants.LENGTH) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }
        return elements;
    }

    public static void containsCheck(int target, List<Integer> numbers) {
        if (numbers.contains(target)) {
            throw new IllegalArgumentException(CONTAINS_ERROR_MESSAGE);
        }
    }
}
