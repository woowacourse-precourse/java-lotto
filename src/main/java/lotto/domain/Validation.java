package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Validation {
    private static final String NUMERIC_PATTERN_WITH_COMMA="[\\d+,]";
    private static final String NUMERIC_PATTERN="\\d+";
    private static final String BLANK="";

    private static final int PROPER_QUANTITY = 6;
    private static final int AMOUNT_UNIT = 1000;
    private static final int PROPER_AMOUNT_CONDITION = 0;

    private static final String WRONG_LETTER_MESSAGE="[ERROR] 금액을 잘못 입력하셨습니다.";
    private static final String WRONG_AMOUNT_UNIT_MESSAGE="[ERROR] 최소 구매 단위는 1,000원입니다.";
    private static final String WRONG_DUPLICATE_MESSAGE="[ERROR] 숫자가 중복되었습니다.";
    private static final String WRONG_PROPER_QUANTITY_MESSAGE="[ERROR] 추첨 번호가 6개가 아닙니다.";

    public static void validateProperLetters(String purchaseAmount) {
        if (!purchaseAmount.replaceAll(NUMERIC_PATTERN, BLANK).equals(BLANK)) {
            System.out.println(WRONG_LETTER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateProperUnitAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (amount % AMOUNT_UNIT != PROPER_AMOUNT_CONDITION) {
            System.out.println(WRONG_AMOUNT_UNIT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    public static void validateProperBonusNumber(String givenNumber) {
        String numberRemovedLetters = givenNumber.replaceAll(NUMERIC_PATTERN, BLANK);
        if (!numberRemovedLetters.equals(BLANK)) {
            System.out.println(WRONG_LETTER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    public static void validateProperRaffleNumber(String givenNumber) {
        String numberRemovedLetters = givenNumber.replaceAll(NUMERIC_PATTERN_WITH_COMMA, BLANK);
        if (!numberRemovedLetters.equals(BLANK)) {
            System.out.println(WRONG_LETTER_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateProperQuantity(List<Integer> raffleNumbers) {
        if (raffleNumbers.size() != PROPER_QUANTITY) {
            System.out.println(WRONG_PROPER_QUANTITY_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicatedNumbers(List<Integer> numbers) {
        int numberOfUniqueNumbers;
        Stream<Integer> lottoNumbers = numbers.stream();
        numberOfUniqueNumbers = (int) lottoNumbers.distinct().count();
        if (numberOfUniqueNumbers != PROPER_QUANTITY) {
            System.out.println(WRONG_DUPLICATE_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
