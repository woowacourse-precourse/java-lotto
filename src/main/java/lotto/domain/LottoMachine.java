package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public void draw(List<Integer> wins, List<Integer> bonuses) {
        List<String> inputs = inputNumber();
    }

    private List<String> inputNumber() {
        List<String> inputs = Arrays.asList(Console.readLine().split(","));
        return inputs.stream().filter(s -> !s.isBlank()).collect(Collectors.toList());
    }

    private List<Integer> formatStringToNumber(List<String> numbers) {
        return null;
    }

    private void checkNumericString(String number) {
    }

    private void checkAlreadyExistedNumber(List<Integer> numbers, int number) {
    }

    public List<Integer> publish() {
        return null;
    }
}
