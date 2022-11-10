package lotto.service;

import lotto.domain.MyLottoNumbers;
import lotto.view.InputOutputView;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    /**
     * 1000원 단위로 구입 금액을 입력받음
     * 1000단위가 아닐 경우 예외 처리
     */
    private final static int DIVIDE_VALUE = 1000;

    InputOutputView inputOutputView = new InputOutputView();
    private int howMany(int money) {
        return money/DIVIDE_VALUE;
    }

    public List<List<Integer>> buyLotto(int money) {
        MyLottoNumbers myLottoNumbers = new MyLottoNumbers();
        List<List<Integer>> myLottos = new ArrayList<>();
        int quantity = howMany(money);

        inputOutputView.buyFin(quantity);

        for (int i = 0; i < quantity; i++) {
            myLottos.add(myLottoNumbers.getMyLottoNumbers());
        }
        inputOutputView.myLottos(myLottos);

        return myLottos;
    }
}
