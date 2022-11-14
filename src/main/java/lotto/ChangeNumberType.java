package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeNumberType {
    private final String number;

    public ChangeNumberType(String number) {
        this.number = number;
    }

    public int getNumber() {
        return changeNumberToString(number);
    }

    public List<Integer> getNumbers() {
        return changeNumbersToString(number);
    }

    private int changeNumberToString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> changeNumbersToString(String number) {
        try {
            return Arrays.stream(number.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
