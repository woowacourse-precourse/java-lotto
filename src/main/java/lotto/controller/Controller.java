package lotto.controller;

import lotto.Lotto;
import lotto.domain.User;
import lotto.service.Service;
import lotto.view.LottoListView;
import lotto.view.PurchaseAmountInputView;
import lotto.view.View;

import java.util.List;

public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    //구입굼액을을 입력해주새요 뷰를 생성한다.
    public View createPurchaseAmountInputView(){
        return new PurchaseAmountInputView();
    }

    public View buyLottos(String amount) {
        User user= service.saveUser(amount);
        List<Lotto> lottos= service.genLottos(user);

        return new LottoListView(lottos);
    }
}
