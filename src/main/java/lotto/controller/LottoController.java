package lotto.controller;

import lotto.view.WinnigOutput;
import lotto.domain.*;
import lotto.view.LottoNumberOutput;
import lotto.view.UserInputView;

public class LottoController {
    public void lottoPlay(){
        try{
            System.out.println(UserInputView.INPUT_MONEY.getInputMessage());
            UserPay userPay = new UserPay(UserInputView.userInput());
            genetateLotto(userPay.lottoCount());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void genetateLotto(int lottoCount){
        GenerateLottoNumber userLotto = new GenerateLottoNumber(lottoCount);
        LottoNumberOutput lottoNumberOutput = new LottoNumberOutput(userLotto.getLottoNumber());
        lottoNumberOutput.lottoNumberOutput();

        WinNumber winner = new WinNumber();
        WinningCalculate rank = new WinningCalculate(
                winner.getWINNER_NUMBER(),userLotto.getLottoNumber(), winner.getBONUS_NUMBER());
        WinningMoney winningMoney = new WinningMoney(rank.getRANK());
        WinnigOutput.FIRST.winningOutput(winningMoney.getRANKCOUNT());
        Yield yield = new Yield(winningMoney.getMONEY(),lottoCount);
    }

}
