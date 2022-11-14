package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.BuyLotto.MININUM_LOTTO_PURCHASE;
import static lotto.domain.BuyLotto.howMuchBuy;
import static lotto.domain.CompareLottoNumbers.compareNumbers;
import static lotto.domain.CreateLottoNumber.createRandomLotto;
import static lotto.domain.LottoNumber.getLottoNumbers;
import static lotto.view.InputLottoView.printHowMuch;

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

    public static void run() {
        buyLotto();
    }

    private static void buyLotto() {
        int runMoney = howMuchBuy(printHowMuch());
        int runCycle = runMoney / MININUM_LOTTO_PURCHASE;
        int[] ranks = {0, 0, 0, 0, 0};
        System.out.println("1000입력" + runCycle);
        List<List<Integer>> randomLottoNumbers = new ArrayList<>();
        Lotto myLotto = new Lotto(getLottoNumbers());
        System.out.println(myLotto.numbers.size());
        System.out.println(myLotto.numbers);

        for (int i = 0; i < runCycle; i++) {
            randomLottoNumbers.add(createRandomLotto());
            System.out.println(randomLottoNumbers);
        }
        for (int i = 0; i < runCycle; i++) {
            ranks[compareNumbers(myLotto.numbers, randomLottoNumbers.get(i))]++;
        }
        for(int i=0; i<ranks.length; i++)
            System.out.print(ranks[i]);

    }

    // TODO: 추가 기능 구현
}
