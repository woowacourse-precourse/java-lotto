package lotto.service;

import lotto.domain.MyLottoNumbers;
import lotto.view.InputOutputView;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private final static int DIVIDE_VALUE = 1000;

    InputOutputView inputOutputView = new InputOutputView();

    public int buyLotto(int money) {
        int quantity = money / DIVIDE_VALUE;
        inputOutputView.buyFin(quantity);
        return quantity;
    }
    public List<List<Integer>> getMyLottoNumbers(int quantity) {
        List<List<Integer>> myLottos = new ArrayList<>();
        MyLottoNumbers myLottoNumbers = new MyLottoNumbers();

        for (int i = 0; i < quantity; i++) {
            myLottos.add(myLottoNumbers.getMyLottoNumbers());
        }

        inputOutputView.myLottos(myLottos);
        return myLottos;
    }
}
