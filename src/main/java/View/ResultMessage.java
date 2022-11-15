package View;

import enumCollections.RankNumber;
import enumCollections.ResultStatistics;
import lotto.Lotto;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

public class ResultMessage {
    public static void printLottoInformation(List<Lotto> lottos) {
        printNumberOfPurchaseLottos(lottos.size());
        print(lottos);
    }

    public static void printNumberOfPurchaseLottos(int number) {
        print(
                ResultStatistics.NUMBER_OF_PURCHASE,
                Integer.toString(number)
        );
    }

    public static void printYield(double yield) {
        BigDecimal yieldIncludeZeros = new BigDecimal(Double.toString(yield));
        print(
                ResultStatistics.YIELD,
                yieldIncludeZeros.toPlainString()
        );
    }

    public static void printStatistics(EnumMap<RankNumber, Integer> resultStatistics) {
        print(ResultStatistics.GUIDE_MESSAGE);
        print(ResultStatistics.LINE);
        getCompleteStatistics(resultStatistics);
    }

    private static void getCompleteStatistics(EnumMap<RankNumber, Integer> resultStatistics) {
        for (ResultStatistics rank : ResultStatistics.values()) {
            if (rank.equals(ResultStatistics.NUMBER_OF_PURCHASE)) {
                break;
            }
            print(
                    rank,
                    resultStatistics.get(ResultStatistics.getRankNumber(rank)).toString()
            );
        }
    }

    public static void print(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLottoNumbers();
        }
    }

    public static void print(ResultStatistics rank) {
        System.out.println(ResultStatistics.getMessage(rank));
    }

    public static void print(ResultStatistics rank, String value) {
        System.out.printf(ResultStatistics.getMessage(rank).concat("\n"), value);
    }
}
