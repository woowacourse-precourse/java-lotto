package lotto;

import java.util.ArrayList;

public class ChangeNumberType {
    private final String number;

    public ChangeNumberType(String number) {
        this.number = number;
    }

    public int getNumber() {
        return changeNumberToString(number);
    }

    public ArrayList<Integer> getNumbers() {
        return null;
    }

    private int changeNumberToString(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
