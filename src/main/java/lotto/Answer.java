package lotto;

import io.Input;
import io.Output;
import io.Sentence;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Answer {

    public static List<Integer> InputAnswer(Input input, Output output) {
        String answerInput = input.getInput(Sentence.INPUTANSWER.getValue(), output);
        InputValidity(answerInput);
        return splitValidity(splitByComma(answerInput));
    }

    private static String InputValidity(String answerInput) {
        long count = answerInput.chars()
            .filter(Character::isDigit)
            .count();
        long commaCount = answerInput.chars()
            .filter(c -> c == ',')
            .count();
        if (count + commaCount != answerInput.length() || commaCount != 5) {
            throw new IllegalArgumentException("Winning number is not valid");
        }
        if (answerInput.contains(",,") == true) {
            throw new IllegalArgumentException("Winning number is not valid");
        }
        return answerInput;
    }

    private static List<Integer> splitByComma(String answerInput) {
        List<Integer> splited;
        splited = Arrays.asList(answerInput.split(",")).stream()
            .map(s -> Integer.parseInt(s))
            .collect(Collectors.toList());
        return splited;
    }

    private static List<Integer> splitValidity(List<Integer> splittedAnswers) {
        long count = splittedAnswers.stream()
            .filter(c -> c >= 1)
            .filter(c -> c <= 45)
            .count();
        if (count != splittedAnswers.size()) {
            throw new IllegalArgumentException("Winning number is not valid");
        }
        return splittedAnswers;
    }
}
