package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputNumbers() {
        String[] numbers = Console.readLine().split(",");
        return Arrays.stream(numbers).map(Integer::valueOf).collect(Collectors.toList());
    }
}
