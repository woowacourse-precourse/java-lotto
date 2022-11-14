package lotto;

import lotto.view.LottoServiceView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoServiceView lottoServiceView = new LottoServiceView();
        int numberOfLotto = lottoServiceView.buyLotto();
    }
}
