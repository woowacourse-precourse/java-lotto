package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.handler.InputMoneyHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PickRandomLotto {
    private final int LIMIT_LOTTO = 6;
    InputMoney inputMoney = new InputMoney();
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    List<List<Integer>> randomLottoLists = new ArrayList<>();
    public void PickRandomNumber(int lottoPapers) {
        while(randomLottoLists.size() != lottoPapers)   {
            List<Integer> sixLottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,LIMIT_LOTTO);
            switchAddOrReturn(sixLottoNumbers);
        }
        checkRandomLottoLists();
    }
    public void switchAddOrReturn(List<Integer> sixLottoNumbers)    {
        if(sixLottoNumbers.stream().distinct().count() != LIMIT_LOTTO){
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
        if(sixLottoNumbers.stream().distinct().count() == LIMIT_LOTTO){
            Lotto lotto = new Lotto(sixLottoNumbers);
            randomLottoLists.add(sixLottoNumbers);
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