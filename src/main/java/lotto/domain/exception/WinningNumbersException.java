package lotto.domain.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.constants.ExceptionMessage;

public class WinningNumbersException {

    private static final int DIGIT_NUM = 6;
    private static final String REGULAR_PATTERN = "^[1-9]*$";
    private static final int START_BETWEEN_NUMBER = 1;
    private static final int LAST_BETWEEN_NUMBER = 45;

    public String winningNumbersVerification(String readLine) {
        List<String> words = cutWord(readLine);
        validateNumbers(words);


        validateZero(words);
        validateCharacters(words);

        validateBetween(words);
        validateDuplicate(words);
        return readLine;
    }

    private List<String> cutWord(String readLine) {
        List<String> list = new ArrayList<>();
        for (String word : readLine.split(",")) {
            list.add(word);
        }
        return list;
    }

    private void validateBetween(List<String> words) {
        for (String oneWord : words) {
            int number = Integer.parseInt(oneWord);
            if (!(number >= START_BETWEEN_NUMBER && number <= LAST_BETWEEN_NUMBER)) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBERS_BETWEEN);
            }
        }
    }

    private void validateNumbers(List<String> words) {
        if (words.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }
    }

    public void validateCharacters(List<String> words) {
        for (String oneWord : words) {
            if (!(oneWord.matches(REGULAR_PATTERN))) {
                throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_CHARACTERS);
            }
        }

    }

    private void validateZero(List<String> words) {
        for (String oneWord : words) {
            if (oneWord.equals("0")) {
                throw new IllegalArgumentException(ExceptionMessage.ZERO_INPUT);
            }
        }
    }

    private void validateDuplicate(List<String> words) {
        HashSet<String> hashSet = new HashSet<>((words));

        if (hashSet.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }
    }
}

