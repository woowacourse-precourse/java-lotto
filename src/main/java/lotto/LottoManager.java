package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManager {
    private Lotto lotto;
    List<Integer> user_input = new ArrayList<>();

    public void LottoStart() {

    }

    private void LottoInput() {
        String[] input = Console.readLine().split(",");
        for (int i = 0; i < input.length; i++) {
            this.user_input.add(Integer.valueOf(input[i]));
        }
    }
}
