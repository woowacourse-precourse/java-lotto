package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameView {

    public static void printProfitRange(double result) {
        System.out.println("총 수익률은 " + String.format("%.1f", result)+ "%입니다.");
    }

    public static void printWinLottoStats(GameScore gameScore) {
        System.out.println("당첨 통계\n---");
        List<LottoWinType> mapKeySet = new ArrayList<>(gameScore.getLottoWinType().keySet());
        mapKeySet.sort(Comparator.comparing(LottoWinType::getIndex));

        for (LottoWinType winType : mapKeySet) {
            if (winType == LottoWinType.ELSE) {
                continue;
            }
            System.out.println(getWinTypePrintText(winType) + gameScore.getLottoWinType().get(winType) + "개");
        }
    }

    private static String getWinTypePrintText(LottoWinType winType) {
        if (winType == LottoWinType.FIRST) {
            return "6개 일치 (2,000,000,000원) - ";
        }

        if (winType == LottoWinType.SECOND) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        }

        if (winType == LottoWinType.THIRD) {
            return "5개 일치 (1,500,000원) - ";
        }

        if (winType == LottoWinType.FOURTH) {
            return "4개 일치 (50,000원) - ";
        }

        if (winType == LottoWinType.FIFTH) {
            return "3개 일치 (5,000원) - ";
        }
        return "";
    }
}
