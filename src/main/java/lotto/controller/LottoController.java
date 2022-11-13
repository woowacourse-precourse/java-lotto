package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.resources.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final int ONE_THOUSAND_WON = 1000;
    private final int PLUS_COUNT = 1;
    private int purchaseAmount;
    private int lottoIssueCount;
    private int bonusNumber;

    private List<Lotto> myLotto = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();

    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playLottoProgram() {
        try {
            setPurchaseAmount();
            setLottoIssueCount();
            issueLottoSeveralTimes(lottoIssueCount, myLotto);
            outputView.printLottoPurchaseInformation(myLotto, lottoIssueCount);
            setWinningNumber();
            setBonusNumber();
            setResult(myLotto, winningNumber, bonusNumber);
            Calculator calculator = new Calculator();
            calculator.calculateTotalEarnings(result);
            calculator.calculateEarningsRate(purchaseAmount);
            outputView.printLottoResult(result, calculator.getEarningsRate());
        } catch (IllegalArgumentException exception) {
        }
    }

    private void setPurchaseAmount() {
        this.purchaseAmount = inputView.enterPurchaseAmount();
    }

    private void setLottoIssueCount() {
        this.lottoIssueCount = purchaseAmount / ONE_THOUSAND_WON;
    }

    private void issueLottoSeveralTimes(int lottoIssueCount, List<Lotto> myLotto) {
        for (int count = 0; count < lottoIssueCount; count++) {
            LottoMachine lottoMachine = new LottoMachine();
            Lotto lotto = new Lotto(lottoMachine.issueLotto());
            myLotto.add(lotto);
        }
    }

    private void setWinningNumber() {
        this.winningNumber = inputView.enterWinningNumber();
    }

    private void setBonusNumber() {
        this.bonusNumber = inputView.enterBonusNumber(winningNumber);
    }

    private void setResult(List<Lotto> myLotto, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for (int i = 0; i < myLotto.size(); i++) {
            List<Integer> myLottoNumber = myLotto.get(i).getLottoNumbers();
            int sameNumberCount = compareMyLottoWithWinningNumber(myLottoNumber, winningNumber);
            int rank = getRank(sameNumberCount);
            if (rank == Rank.THIRD_PLACE.getRank() && checkBonusNumber(myLottoNumber, bonusNumber)) {
                rank = Rank.SECOND_PLACE.getRank();
            }
            result.set(rank, result.get(rank) + PLUS_COUNT);
        }
        this.result = result;
    }

    private int compareMyLottoWithWinningNumber(List<Integer> myLottoNumber, List<Integer> winningNumber) {
        int sameNumberCount = 0;
        for (int index = 0; index < myLottoNumber.size(); index++) {
            if (winningNumber.contains(myLottoNumber.get(index))) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    private int getRank(int sameNumberCount) {
        if (sameNumberCount == 6) {
            return Rank.FIRST_PLACE.getRank();
        }
        if (sameNumberCount == 5) {
            return Rank.THIRD_PLACE.getRank();
        }
        if (sameNumberCount == 4) {
            return Rank.FOURTH_PLACE.getRank();
        }
        if (sameNumberCount == 3) {
            return Rank.FIFTH_PLACE.getRank();
        }
        return Rank.NOTHING.getRank();
    }

    private boolean checkBonusNumber(List<Integer> myLottoNumber, int bonusNumber) {
        if (myLottoNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
