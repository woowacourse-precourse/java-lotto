package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumbersReceiver {
    NumbersReceiver() {}

    public int insertMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> setBasicNumbers() throws IllegalArgumentException {
        String[] correctNumbers = Console.readLine().split(",");
        List<Integer> result = new ArrayList<>();

        try {
            for (String singleNumber : correctNumbers) {
                result.add(Integer.parseInt(singleNumber));
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 분리된 숫자만 입력 가능합니다.");
        }

        return result;
    }

    public int setBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능 합니다.");
        }
    }
}
