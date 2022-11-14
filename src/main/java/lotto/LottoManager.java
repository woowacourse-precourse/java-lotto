package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManager {
    private Lotto lotto;
    private int cash = 0;
    private List<Integer> user_input = new ArrayList<>();
    private int bonus_num = 0;

    public void LottoStart() {
    }

    private void LottoInput() {
        this.cash = Integer.valueOf(Console.readLine());
        String[] input = Console.readLine().split(",");
        for (int i = 0; i < input.length; i++) {
            this.user_input.add(Integer.valueOf(input[i]));
        }
        this.bonus_num = Integer.valueOf(Console.readLine());
    }
}
