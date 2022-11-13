package controller;

import view.RequestView;

public class LottoController {

    private RequestView requestView = new RequestView();

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
    }

}
