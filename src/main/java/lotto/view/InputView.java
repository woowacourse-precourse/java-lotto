package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputNumbers() {
        List<Integer> result = new ArrayList<>();
        return result;
    }
}
