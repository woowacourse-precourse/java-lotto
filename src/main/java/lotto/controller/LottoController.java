package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.MyLottoList;
import lotto.PrizeLotto;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    public static MyLottoList generateMyLottoInstance(int money) {
        return new MyLottoList(money);
    }

    public static Lotto generateOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortAscendingOrder(numbers);
        return new Lotto(numbers);
    }

    public static void sortAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public static void generateMyLottoList(MyLottoList myLottoList) {
        List<Lotto> tempList = new ArrayList<>();
        for(int i=0 ; i<myLottoList.getNumber() ; i++) {
            tempList.add(generateOneLotto());
        }
        myLottoList.setLotto(tempList);
    }

    public static PrizeLotto generatePrizeLottoInstance() {
        Lotto prizeLotto = new Lotto(LottoView.inputPrizeLotto());
        return new PrizeLotto(prizeLotto);
    }

    public static void addBonusNum(int bonusNum, PrizeLotto prizeLotto) {
        prizeLotto.setBonusNumber(bonusNum);
    }
}
