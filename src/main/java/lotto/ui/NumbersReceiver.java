package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumbersReceiver {
    NumbersReceiver() {}

    public int insertMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> setBasicNumbers() {
        String[] correctNumbers = Console.readLine().split(",");
        List<Integer> result = new ArrayList<>();

        for (String singleNumber : correctNumbers) {
            result.add(Integer.parseInt(singleNumber));
        }

        return result;
    }

    public int setBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
