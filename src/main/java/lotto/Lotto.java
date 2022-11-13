package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException();
    }

    public static void buyLotto(int money, List<Lotto> lotto) {
        int lottoQTY = money / 1000;
        for (int i = 0; i < lottoQTY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        }
    }

    private void numSort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int getNum(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNums() {
        return numbers;
    }
}
