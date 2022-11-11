package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    private int purchaseAmount;
    private int lottoIssueCount;
    private int bonusNumber;

    private List<Lotto> myLotto = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

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
    private void setResult(List<Lotto> myLotto, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0));
        for (int i = 0; i < myLotto.size(); i++) {
            List<Integer> myLottoNumber = myLotto.get(i).getLottoNumbers();
            int sameNumberCount = compareMyLottoWithWinningNumber(myLottoNumber, winningNumber);
        }
        this.result = result;
    }
    private int compareMyLottoWithWinningNumber(List<Integer> myLottoNumber, List<Integer> winningNumber) {
        int sameNumberCount = 0;
        for (int i = 0; i < myLottoNumber.size(); i++) {
            if (winningNumber.contains(myLottoNumber.get(i))) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

}
