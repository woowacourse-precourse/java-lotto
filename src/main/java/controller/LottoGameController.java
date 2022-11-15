package controller;

import generator.LottoNumberGenerator;
import lotto.*;
import view.UserInputView;
import view.UserOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    public void gameStart() {
        try {
            List<Lotto> purchaseLottoList = getPurchaseLottoList();
            getLottoWinningResult(purchaseLottoList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }

    }

    private void getLottoWinningResult(List<Lotto> purchaseLottoList) {
        Lotto winningLottoNumber = UserInputView.getWinningLottoNumber();
        BonusNumber bonusLottoNumber = UserInputView.getBonusLottoNumber();
        WinningLottoNumber winningLottoNumbers = new WinningLottoNumber(winningLottoNumber, bonusLottoNumber);
        LottoResult lottoResult = new LottoResult(purchaseLottoList, winningLottoNumbers);
        UserOutputView.printLottoResult(lottoResult);
    }

    private List<Lotto> getPurchaseLottoList() {
        PurchaseMoney purchaseMoney = UserInputView.getPurchaseMoney();
        List<Lotto> purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseMoney.getNumberLotteryPurchasesAvailable(); i++) {
            purchaseLottoList.add(LottoNumberGenerator.makeLottoNumberGenerator());
        }
        UserOutputView.printPurchaseNumber(purchaseMoney);
        for (Lotto lotto : purchaseLottoList) {
            UserOutputView.printPurchaseLottoNumber(lotto);
        }
        return purchaseLottoList;
    }
}
