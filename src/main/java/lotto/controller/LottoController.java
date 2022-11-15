package lotto.controller;

import lotto.domain.*;
import lotto.view.View;

import java.util.List;

public class LottoController {
    private static final View view = new View();
    private static final Validator  validator= new Validator();
    public void lottoGame(){
        String input = view.startLottoView();
        if(!validator.validateInputAmount(input)){
            return;
        }
        LottoTickets lottoTickets = purchaseLotto(input);
        String winningNumber = view.winningNumberInputView();
        if(!validator.validateWinningNumber(winningNumber)){
            return;
        }
        Lotto WinningLotto = new Lotto(LottoNumber.winningNumberToList(winningNumber));
        String bonusNumber = view.bonusNumberInputView();
        if(!validator.validateBonusNumber(WinningLotto, bonusNumber)){
            return;
        }
        int[] result = Calculator.calculateRank(lottoTickets, WinningLotto, Integer.parseInt(bonusNumber));
        double rateOfReturn = Calculator.calculateRateOfReturn(result, lottoTickets.length());
        view.resultView(result, rateOfReturn);
    }

    private LottoTickets purchaseLotto(String input){
        int lottoCount  = Integer.parseInt(input) / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoCount);
        view.lottoListView(lottoTickets);
        return lottoTickets;
    }
}
