package lotto;

import lotto.randomNumber.RandomNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoughtLotto extends Lotto{
    public BoughtLotto() {
        super(RandomNumber.createNumber());
    }

    public BoughtLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void printLottoNumber() {
        List<Integer> numbers = super.getLotto();
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
