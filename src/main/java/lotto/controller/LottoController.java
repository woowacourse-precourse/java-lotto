package lotto.controller;

import lotto.view.IntroduceView;
import lotto.view.View;

public class LottoController {
    public void showIntroduce() {
        View view = new IntroduceView();
        view.Show();
    }
}
