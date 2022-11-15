package lotto.lotto;

import lotto.lotto.randomNumber.RandomNumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BoughtLotto extends Lotto{
    public BoughtLotto() {
        super(RandomNumber.createNumber());
    }

    public BoughtLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void printLottoNumber() {
        List<Integer> numbers = super.getLotto();
        numbers = numbers.stream()
                .collect(Collectors.toList());
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
