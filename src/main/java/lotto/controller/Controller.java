package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.LottoInputRequester;
import lotto.view.LottoResultRespondent;
import lotto.view.UserInputRequester;

public class Controller {

    private final UserInputRequester userInputRequester = new UserInputRequester();
    private final LottoInputRequester lottoInputRequester = new LottoInputRequester();
    private final LottoResultRespondent lottoResultRespondent = new LottoResultRespondent();

    public void startLotto() {
        User user = userInputRequester.setLottoNumbers();
        Lotto lotto = lottoInputRequester.setLottoWinningNumber();
        lottoResultRespondent.printLottoResult(lotto, user);
    }
}
