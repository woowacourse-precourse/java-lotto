package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    public int getInput() {
        return Integer.parseInt(input());
    }

    public List<String> guessLottoNumbers() {
        String numbers = input();

        return new ArrayList<>(Arrays.asList(numbers.split("\\s*,\\s*")));
    }

    private static String input() {
        return Console.readLine();
    }
}
