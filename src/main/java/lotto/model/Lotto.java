package lotto;

import lotto.model.Money;
import lotto.model.RandomNumber;
import lotto.view.Print;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
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
            Lotto lotto = new Lotto(createdRandomNumbers);
            Compare.randomLottos.put(i, lotto.numbers);
            Print.getLottos(lotto.numbers);
        }
    }
}
