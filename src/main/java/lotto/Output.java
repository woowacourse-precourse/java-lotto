package lotto;

import java.text.DecimalFormat;

public class Output {

    private static final int MIN_MATCH_LOTTO_NUMBER_COUNT = 0;
    private static final int DECIMAL_POINT = 100;

    public static void printLottoCount(UserAmount userAmount) {
        System.out.println(userAmount.calculateLottoCount() + "개를 구매했습니다.");
        System.out.println();
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        for (Lotto numbers : lottoNumbers.getLottoNumbers()) {
            System.out.println(numbers.getNumbers());
        }
    }

    public static void printRankingMsg() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printRanking(Ranking ranking, Results totalLottoRankingCount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (ranking.getMatchCount() > MIN_MATCH_LOTTO_NUMBER_COUNT) {
            System.out.println(ranking.getMatchCount() + "개 일치 (" +
                    decimalFormat.format(ranking.getPrizeMoney()) + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking) + "개");
        }
        if (Ranking.SECOND == ranking) {
            System.out.println(ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" +
                    decimalFormat.format(ranking.getPrizeMoney()) + "원) - " +
                    totalLottoRankingCount.getLottoRankingCount().get(ranking) + "개");
        }
    }

    public static void printProfitsRate(int totalAmount, UserAmount userAmount) {
        System.out.println("총 수익률은 " + String.format("%.1f",
                (((double) totalAmount / (double) userAmount.getAmount())) * DECIMAL_POINT) + "%입니다.");
    }

}
