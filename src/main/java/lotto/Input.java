package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    static List<Integer> number() {
        List<Integer> winNum = new ArrayList<>();

        String inputNum = Console.readLine();

        String[] winNumber = inputNum.split(",");

        for (String i : winNumber) {

            winNum.add(Integer.valueOf(i));
        }

        return winNum;
    }


}
