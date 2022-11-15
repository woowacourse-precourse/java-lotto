package lotto.view;

import lotto.domains.Lotto;
import lotto.domains.Place;
import lotto.utils.LottoNumberConverter;

import java.util.List;
import java.util.Map;

import static lotto.domains.Place.*;

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

    public static void printUserHitInformation(Map<Place, Integer> prizeMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeMap.get(FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeMap.get(FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeMap.get(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeMap.get(SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeMap.get(FIRST) + "개");
    }
}
