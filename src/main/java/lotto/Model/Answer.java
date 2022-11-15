package lotto.Model;

import lotto.resources.Sentence;
import lotto.resources.Constants;
import lotto.resources.ExceptionCatcher;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

import java.util.stream.Collectors;

public class Answer {

    private static final char comma = ',';

    public static List<Integer> lottoAnswerGenerator(String answerInputByUser) {
        inputValidity(answerInputByUser.trim());
        return splitValidity(splitByComma(answerInputByUser.trim()));
    }

    public static void inputValidity(String answerInput) {
        long count = answerInput.chars()
                .filter(Character::isDigit).count();
        long commaCount = answerInput.chars()
                .filter(c -> c == comma).count();
        try {
            if (count + commaCount != answerInput.length() || commaCount != Constants.COMMA_NUMBER.getValue()) {
                throw new IllegalArgumentException(Sentence.WINNING_NOT_VALID.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.WINNING_NOT_VALID.getValue());
        }
        validElements(answerInput);
    }

    private static List<Integer> splitByComma(String answerInput) {
        List<Long> splited;
        try {
            splited = Arrays.stream(answerInput.split("" + comma))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ExceptionCatcher(Sentence.WINNING_TWO_COMMA.getValue());
        }
        return splited.stream().mapToInt(Long::intValue).boxed().collect(Collectors.toList());
    }

    private static List<Integer> splitValidity(List<Integer> splitAnswers) {
        long count = splitAnswers.stream()
                .filter(c -> c >= Constants.FROM.getValue()).filter(c -> c <= Constants.TO.getValue()).count();
        try {
            if (count != splitAnswers.size()) {
                throw new IllegalArgumentException(Sentence.WINNING_NOT_VALID.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.WINNING_NOT_VALID.getValue());
        }
        return splitAnswers;
    }

    private static void validElements(String answerInput) {
        List<Integer> splitNumbers = splitValidity(splitByComma(answerInput));
        HashSet<Integer> numContained = new HashSet<>(splitNumbers);
        try {
            if (numContained.size() != Constants.LOTTO_LENGTH.getValue() ||
                    splitNumbers.size() != Constants.LOTTO_LENGTH.getValue()) {
                throw new IllegalArgumentException(Sentence.WINNING_DUPLICATED.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.WINNING_DUPLICATED.getValue());
        }
    }
}
