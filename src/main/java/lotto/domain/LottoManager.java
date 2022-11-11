package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private int purchaseAmount;
    private int lottoIssueCount;
    private int bonusNumber;

    private List<Lotto> myLotto = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();

    private void savePurchaseAmount() {
        this.purchaseAmount = InputView.enterPurchaseAmount();
    }
    private void saveLottoIssueCount() {
        this.lottoIssueCount = purchaseAmount / 1000;
    }
    private void issueLottoSeveralTimes(int lottoIssueCount, List<Lotto> myLotto) {
        for (int count = 0; count < lottoIssueCount; count++) {
            LottoMachine lottoMachine = new LottoMachine();
            Lotto lotto = new Lotto(lottoMachine.issueLotto());
            myLotto.add(lotto);
        }
    }
    private void saveWinningNumber() {
        this.winningNumber = InputView.enterWinningNumber();
    }
    private void saveBonusNumber() {
        this.bonusNumber = InputView.enterBonusNumber();
    }

}
