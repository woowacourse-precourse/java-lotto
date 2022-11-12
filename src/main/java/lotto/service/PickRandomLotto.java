package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickRandomLotto {
    private final int LIMIT_LOTTO = 6;
    InputMoney inputMoney = new InputMoney();
    List<List<Integer>> randomLottoLists = new ArrayList<>();
    public void PickRandomNumber(int lottoPapers) {
        while(randomLottoLists.size() != lottoPapers)   {
            List<Integer> sixLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,LIMIT_LOTTO);
            if(sixLottoNumbers.stream().distinct().count() != LIMIT_LOTTO){
                return;
            }
            if(sixLottoNumbers.stream().distinct().count() == LIMIT_LOTTO){
                Lotto lotto = new Lotto(sixLottoNumbers);
                randomLottoLists.add(sixLottoNumbers);
            }
        }
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