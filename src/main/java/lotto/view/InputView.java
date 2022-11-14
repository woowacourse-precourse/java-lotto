package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private String inputToQuestion() {
        return Console.readLine();
    }

    public int convertToNumber() {
        try {
            return Integer.parseInt(inputToQuestion());
        }
        catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertToList() {
        try {
            return Arrays.stream(inputToQuestion().split(", "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
