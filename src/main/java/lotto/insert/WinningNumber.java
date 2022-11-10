package lotto.insert;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private String winningNumber;
    private List<Integer> integerList = new ArrayList<>();

    public WinningNumber(String insertLine) {
        this.winningNumber = Console.readLine();
    }

    void iterator() {

        String replace = winningNumber.replace(",", "");
        char[] separate = replace.toCharArray();

        for (char character : separate) {
            integerList.add((int) character);
        }

    }

    public List<Integer> getWinningNumber() {
        return integerList;
    }
}
