package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoBroadcast {

    List<Integer> winNumber = new ArrayList<>();

    public List<Integer> inputWinNumber() {
        String[] inputValue = Console.readLine().split(",");
        for (String value : inputValue) {
            this.winNumber.add(Integer.valueOf(value));
        }
        return this.winNumber;
    }
}
