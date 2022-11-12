package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickRandomLotto {
    public final int LIMIT_LOTTO = 6;
    public static List<List<Integer>> randomLottoLists = new ArrayList<>();
    InputMoney inputMoney = new InputMoney();

    public void PickRandomNumber(int lottoPapers) {
        while(randomLottoLists.size() != lottoPapers) {
            List<Integer> sixLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,LIMIT_LOTTO);
            Lotto lotto = new Lotto(sixLottoNumbers);
        }
        checkRandomLottoLists();
    }

    public void checkRandomLottoLists() {
        Iterator<List<Integer>> iterator = randomLottoLists.iterator();

        while(iterator.hasNext()) {
            List<Integer> values = iterator.next();
            System.out.println(values);
        }
        inputMoney.lineSkip();
    }
}