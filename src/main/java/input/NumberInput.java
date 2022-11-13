package input;

import camp.nextstep.edu.missionutils.Console;
import util.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberInput {

    public NumberInput() {}

    private static final String SEPARATOR = ",";

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        List<Integer> numbers = splitInputSeparator(input);
        return numbers;
    }

    private List<Integer> splitInputSeparator(String input) {
        return Stream.of(input.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int validateConvertingMoney(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NOT_NUMBER_FORMAT);
        }

        return number;
    }

}
