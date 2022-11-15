package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public int number() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    public List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        String values = Console.readLine();

        for (String value : values.split(",")) {
            numbers.add(convertToInt(value));
        }

        return numbers;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 정수로 변환할 수 없습니다.");
        }
    }
}
