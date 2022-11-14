package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Host {
    public Lotto drawNumbers() {
        String numbers = Console.readLine();
        Validator.validateNumbers(numbers);
        List<Integer> lottoNumbers = getListFromString(numbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> getListFromString(String numbers) {
        StringTokenizer st = new StringTokenizer(numbers, ",");
        List<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        return list;
    }

    public Bonus drawBonus(Lotto winningLotto) {
        String number = Console.readLine();
        Validator.validateBonus(number, winningLotto);
        return new Bonus(Integer.parseInt(number));
    }
}
