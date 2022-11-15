package lotto.view;

import lotto.domains.Lotto;
import lotto.utils.LottoNumberConverter;

import java.util.List;

public class Output {
    private Output() {
    }

    public static void printNumberOfPurChase(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public static void printUserLottoNumbers(List<Lotto> lotteries) {
        lotteries.stream()
                .map(Lotto::getNumbers)
                .map(LottoNumberConverter::convertToString)
                .forEach(lottoNumberStr -> System.out.println("[" + lottoNumberStr + "]"));
    }
}
