package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[] ranks = {0, 0, 0, 0, 0, 0};
        printHowMuchPurchase(runCycle);
        List<List<Integer>> randomLottoNumbers = new ArrayList<>();
        Lotto myLotto = new Lotto(getLottoNumbers());
        int bonus = getBonusNumber();
        //System.out.println(myLotto.numbers.size());//
        //System.out.println(myLotto.numbers + " + " + bonus);//
        /*List<Integer> tempList = Arrays.asList(8, 21, 23, 41, 42, 43);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(3, 5, 11, 16, 32, 38);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(7, 11, 16, 35, 36, 44);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(1, 8, 11, 31, 41, 42);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(13, 14, 16, 38, 42, 45);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(7, 11, 30, 40, 42, 43);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(2, 13, 22, 32, 38, 45);
        randomLottoNumbers.add(tempList);
        tempList = Arrays.asList(1, 3, 5, 14, 22, 45);
        randomLottoNumbers.add(tempList);*/

        for (int i = 0; i < runCycle; i++) {
            randomLottoNumbers.add(createRandomLotto());
            System.out.println(randomLottoNumbers.get(i));
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
