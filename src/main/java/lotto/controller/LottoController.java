package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    public void  lottoGameStart(){
        outputView.noticeInputMoney();
        int count = outputView.noticeAmountLotto(inputView.inputUserMoney());
        List<List<Integer>> lottos = OutputView.NoticeInputLottoNumber(InputView.getLottoNumbers(count));
        List<Integer> winningNumber = outputView.winNumber(inputView.getWinNumber());
        int bonusNumber = outputView.noticeInputBonusNumber(inputView.inputBonusNumber(winningNumber));
    }



}
