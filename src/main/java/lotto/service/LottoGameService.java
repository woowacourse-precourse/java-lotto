package lotto.service;

public class LottoGameService {

    public int getLottoIssueCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / 1000;
    }
}
