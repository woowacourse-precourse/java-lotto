package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottoPurchaseInformation(List<Lotto> myLotto) {
        int lottoIssueCount = InputView.getLottoIssueCount();
        System.out.println(lottoIssueCount + "개를 구매했습니다.");

        for (int count = 0; count < lottoIssueCount; count++) {
            System.out.println(myLotto.get(count).getLottoNumbers().toString());
        }
        System.out.println();
    }
}
