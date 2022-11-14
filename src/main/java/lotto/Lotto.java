package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.BuyLotto.MININUM_LOTTO_PURCHASE;
import static lotto.domain.BuyLotto.howMuchBuy;
import static lotto.domain.CompareLottoNumbers.compareNumbers;
import static lotto.domain.CreateLottoNumber.createRandomLotto;
import static lotto.domain.LottoNumber.getBonusNumber;
import static lotto.domain.LottoNumber.getLottoNumbers;
import static lotto.view.InputLottoView.printHowMuch;
import static lotto.view.OutputLottoView.printHowMuchPurchase;
import static lotto.view.OutputLottoView.printWinStat;

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
        int[] ranks = {0,0,0,0,0,0};
        printHowMuchPurchase(runCycle);
        List<List<Integer>> randomLottoNumbers = new ArrayList<>();
        Lotto myLotto = new Lotto(getLottoNumbers());
        int bonus = getBonusNumber();
        System.out.println(myLotto.numbers.size());//
        System.out.println(myLotto.numbers + " + " + bonus);//

        for (int i = 0; i < runCycle; i++) {
            randomLottoNumbers.add(createRandomLotto());
            System.out.println(randomLottoNumbers);
        }
        for (int i = 0; i < runCycle; i++) {
            ranks[compareNumbers(myLotto.numbers, randomLottoNumbers.get(i), bonus)]++;
        }
        /*for(int i=0; i<ranks.length; i++)
            System.out.print(ranks[i]);*/
        System.out.println();
        printWinStat(ranks, runMoney);

    }

}
