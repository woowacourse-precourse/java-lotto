package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private Integer bonusNumber;

    public WinningLotto(String input, String bonusNumber) {
        this.lotto = number(input);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private Lotto number(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(",");
        for (String s : split) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    public List<Lotto> bonusNumber(String input) {
        List<Lotto> lottos = new ArrayList<>();


        return lottos;
    }

}
