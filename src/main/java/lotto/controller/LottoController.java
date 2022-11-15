package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void start() {
        int purchaseQuantity = lottoPurchaseQuantity(InputView.inputLottoPurchaseAmount());
        List<List<Integer>> lottoNumber = lottoIssue(purchaseQuantity);
        List<Integer> gradeCount = winningHistory(lottoNumber, InputView.inputWinningNumber(), InputView.inputBonusNumber());
        lottoReturn(gradeCount, purchaseQuantity);
    }

    private void lottoReturn(List<Integer> gradeCount, int purchaseQuantity) {
        LottoReturnCalculation lottoReturnCalculation = new LottoReturnCalculation(gradeCount, purchaseQuantity);
        OutputView.OutputLottoReturn(lottoReturnCalculation.lottoReturn());
    }

    private List<Integer> winningHistory(List<List<Integer>> lottoNumber, String inputWinningNumber, int inputBonusNumber) {
        WinningNumberChangeList winningNumberChangeList = new WinningNumberChangeList(inputWinningNumber);
        CheckWinningHistory checkingWinningHistory = new CheckWinningHistory(lottoNumber, winningNumberChangeList.changeNumberToList(), inputBonusNumber);
        List<Integer> gradeCount = checkingWinningHistory.checkingGrade();
        OutputView.OutputGradeCount(gradeCount);
        return gradeCount;
    }

    private List<List<Integer>> lottoIssue(int purchaseQuantity) {
        LottoNumberIssue lottoNumberIssue = new LottoNumberIssue(purchaseQuantity);
        List<List<Integer>> lottoNumber = lottoNumberIssue.lottoIssue();
        OutputView.lottoNumber(lottoNumber);
        return lottoNumber;
    }

    private int lottoPurchaseQuantity(int purchaseAmount) {
        LottoQuantityCalculation lottoQuantityCalculation = new LottoQuantityCalculation(purchaseAmount);
        int purchaseQuantity = lottoQuantityCalculation.purchaseQuantity();
        OutputView.OutputLottoPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }
}
