package lotto.controller;

import lotto.domain.LottoNumberIssue;
import lotto.domain.LottoQuantityCalculation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void start() {
        int purchaseQuantity = lottoPurchaseQuantity(InputView.inputLottoPurchaseAmount());
        List<List<Integer>> lottoNumber = lottoIssue(purchaseQuantity);
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
