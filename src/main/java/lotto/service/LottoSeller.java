package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;
    LottoMaker lottoMaker = new LottoMaker();
    public List<Lotto> allLottoOfPurchaser = new ArrayList<>(); // Purchaser 클래스에 있어야 할 변수


    List<Lotto> takeMoneyAndGiveLotto() {
        int numberOfLottoToMake = getNumberOfLottoToMake();

        for (int i = 0; i < numberOfLottoToMake; i++) {
            List<Integer> numbersInOneLotto = lottoMaker.newLotto();
            Lotto newLotto = new Lotto(numbersInOneLotto);
            allLottoOfPurchaser.add(newLotto);
        }
        return allLottoOfPurchaser;
    }

    private int getNumberOfLottoToMake() {
        String moneyAsString = Console.readLine();

        int money = Integer.parseInt(moneyAsString);

        int howManyLotto = money / LOTTO_PRICE;

        return howManyLotto;
    }
}
