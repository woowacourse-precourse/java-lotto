package lotto.controller;

import lotto.view.PurchaseAmountInputView;
import lotto.view.View;

public class Controller {

    //구입굼액을을 입력해주새요 뷰를 생성한다.
    public View createPurchaseAmountInputView(){
        return new PurchaseAmountInputView();
    }
}
