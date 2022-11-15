package lotto.view;

import lotto.reward.Lotto;
import lotto.reward.Numbers;
import lotto.utils.WinningType;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Result {
    public static void printLottoEA(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto -> {
            List<Numbers> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            printLottoNumbers(lottoNumbers);
        });
    }

    private static void printLottoNumbers(List<Numbers> lottoNumbers) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Numbers lottoNumber : lottoNumbers) {
            stringJoiner.add(lottoNumber.getNumber() + "");
        }
        System.out.println(stringJoiner);
    }

    public static void printStatistics(Map<WinningType, Integer> statistics) {
        statistics.forEach((winningType, count) -> printWinningResult(winningType, count));
    }

    private static void printWinningResult(WinningType winningType, Integer count) {
        if (winningType == WinningType.SECOND_PLACE) {
            System.out.println(winningType.getMatchCount() + "개 일치, 보너스 볼 일치 (" + winningType.getWinningAmount() + "원)- " + count + "개");
            return;
        }
        if (winningType != WinningType.NOTHING) {
            System.out.println(winningType.getMatchCount() + "개 일치 (" + winningType.getWinningAmount() + "원)- " + count + "개");
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}

