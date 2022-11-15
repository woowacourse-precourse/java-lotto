package lotto.model;

import lotto.utils.Error;
import lotto.view.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedNumbers(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public static void getAllLottos(){
        int lottoCount = Money.numberOfLottos;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> createdRandomNumbers = RandomNumber.create();
            ArrayList<Integer> realRandomNumbers  = new ArrayList<>(createdRandomNumbers);
            Lotto lotto = new Lotto(realRandomNumbers);
            Compare.randomLottos.put(i, lotto.numbers);
            Print.getLottos(lotto.numbers);
        }
    }

    private static void duplicatedNumbers(List<Integer> winNumbers) throws IllegalArgumentException{
        HashSet<Integer> duplicate = new HashSet<>(winNumbers);
        if (duplicate.size() != 6) {
            throw new IllegalArgumentException(Error.DUPLICATED_NUMBER.getMessage());
        }
    }
}
