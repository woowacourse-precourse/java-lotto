package lotto;

import io.Input;
import io.Output;
import io.Sentence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {

    public static List<Integer> InputAnswer(Input input, Output output) {
        String answerInput = input.getInput(Sentence.INPUT_ANSWER.getValue(), output);
        inputValidity(answerInput);
        return splitValidity(splitByComma(answerInput));
    }

    public static void inputValidity(String answerInput) {
        long count = answerInput.chars()
            .filter(Character::isDigit)
            .count();
        long commaCount = answerInput.chars()
            .filter(c -> c == ',')
            .count();
        if (count + commaCount != answerInput.length() || commaCount != 5) {
            throw new IllegalArgumentException("[ERROR] Winning number is not valid");
        }
        validElements(answerInput);
    }

    private static List<Integer> splitByComma(String answerInput) {
        List<Integer> splited;
        splited = Arrays.asList(answerInput.split(",")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        return splited;
    }

    private static List<Integer> splitValidity(List<Integer> splittedAnswers) {
        long count = splittedAnswers.stream()
            .filter(c -> c >= 1)
            .filter(c -> c <= 45)
            .count();
        if (count != splittedAnswers.size()) {
            throw new IllegalArgumentException("[ERROR] Winning number is not valid");
        }
        return splittedAnswers;
    }

    private static void validElements(String answerInput) {
        List<Integer> splited = splitValidity(splitByComma(answerInput));
        HashSet<Integer> numContained = new HashSet<>(splited);
        if (numContained.size() != 6 || splited.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Duplicated input.");
        }
    }
}
