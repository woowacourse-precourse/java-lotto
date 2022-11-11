package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaser;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;
    LottoMaker lottoMaker = new LottoMaker();
    LottoPurchaser purchaser = new LottoPurchaser();

    public void sellLottoToPurchaser() {
        int numberOfLottoToMake = getNumberOfLottoToMake();
        List<Lotto> newLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfLottoToMake; i++) {
            List<Integer> numbersInOneLotto = lottoMaker.newLotto();
            Lotto newLotto = new Lotto(numbersInOneLotto);
            newLottoList.add(newLotto);
            purchaser.setAllLottoOfPurchaser(newLottoList);
        }
        printAllLotto();
    }


    public void printAllLotto() {
        for (Lotto lotto : purchaser.getAllLottoOfPurchaser()) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    private int getNumberOfLottoToMake() {

        System.out.println("구입금액을 입력해 주세요.");

        String moneyAsString = Console.readLine();

        int money = Integer.parseInt(moneyAsString);

        int howManyLotto = money / LOTTO_PRICE;

        System.out.println(howManyLotto + "개를 구매했습니다.");

        return howManyLotto;
    }
}
