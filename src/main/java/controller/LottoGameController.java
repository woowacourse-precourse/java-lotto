package controller;

import generator.LottoNumberGenerator;
import lotto.*;
import view.UserInputView;
import view.UserOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    public void gameStart() {
        PurchaseMoney purchaseMoney = UserInputView.getPurchaseMoney();
        List<Lotto> purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseMoney.getNumberLotteryPurchasesAvailable(); i++) {
            purchaseLottoList.add(LottoNumberGenerator.makeLottoNumberGenerator());
        }
        System.out.println();
        System.out.println(purchaseMoney.getNumberLotteryPurchasesAvailable()+ "개를 구매했습니다.");
        for(Lotto lotto : purchaseLottoList){
            UserOutputView.printPurchaseLottoNumber(lotto);
        }
        System.out.println();
        Lotto winningLottoNumber = UserInputView.getWinningLottoNumber();
        System.out.println();
        BonusNumber bonusLottoNumber = UserInputView.getBonusLottoNumber();
        System.out.println();
        WinningLottoNumber winningLottoNumbers = new WinningLottoNumber(winningLottoNumber, bonusLottoNumber);
        LottoResult lottoResult = new LottoResult(purchaseLottoList, winningLottoNumbers);
        UserOutputView.printLottoResult(lottoResult);
    }
}
