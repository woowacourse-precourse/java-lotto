package view;

import lotto.*;
import lotto.constant.Rank;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.constant.Rank.*;

public class OutputView {
    private static String PRINT_NUMBER_OF_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static String PRINT_WINNING_HISTORY_START = "당첨 통계\n---";
    private static String PRINT_RANK_STATUS = "%d개 일치%s (%s원) - %d개\n";

    private static String PRINT_BONUS_BALL = ", 보너스 볼 일치 ";

    private static String PRINT_REWARD_RATIO = "총 수익률은 %.1f%%입니다.";


    public static void printLottoCount(LottoCount count) {
        System.out.printf(PRINT_NUMBER_OF_LOTTO_COUNT, count.getLottoCount());
        System.out.println();
    }

    public static void printLottoCollection(LottoCollection lottoCollection) {
        for (Lotto lotto : lottoCollection.copyCollection()) {
            System.out.println(lotto.copyNumbers());
        }
    }

    public static void printWinningResult(LottoRank lottoRank) {
        System.out.println(PRINT_WINNING_HISTORY_START);
        printWinningHistory(lottoRank);
    }

    private static void printWinningHistory(LottoRank lottoRank) {
        DecimalFormat df = new DecimalFormat("###,###");

        List<Rank> reversedRank = lottoRank.reverseByReward();
        for (Rank rank : reversedRank) {
            printRankStatus(rank,lottoRank);

            //아래와 같이 출력했으나 Application Test에서 작동 X
            //System.out.printf(PRINT_RANK_STATUS,
            //  rank.getMatchCount(), classifyRankSecond(rank), df.format(rank.getReward()), lottoRank.getRankCount(rank));
        }
    }

    public static void printRewardRatio(LottoMoney lottoMoney, LottoRank rank) {
        float rewardRatio = calculateRewardRatio(lottoMoney, rank);
        System.out.printf(PRINT_REWARD_RATIO, rewardRatio);
        System.out.println();
    }
    private static void printRankStatus(Rank rank, LottoRank lottoRank){
        if (rank == FIRST_PLACE) {
            System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoRank.getRankCount(rank));
        } else if (rank == SECOND_PLACE) {
            System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoRank.getRankCount(rank));
        } else if (rank == THIRD_PLACE) {
            System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoRank.getRankCount(rank));
        } else if (rank == FOURTH_PLACE) {
            System.out.printf("4개 일치 (50,000원) - %d개\n", lottoRank.getRankCount(rank));
        } else if (rank == FIFTH_PLACE) {
            System.out.printf("3개 일치 (5,000원) - %d개\n", lottoRank.getRankCount(rank));
        }
    }
    private static String classifyRankSecond(Rank rank) {
        if (!rank.equals(SECOND_PLACE)) {
            return "";
        }
        return PRINT_BONUS_BALL;
    }

    private static float calculateRewardRatio(LottoMoney lottoMoney, LottoRank rank) {
        return ((float) rank.calculateRewardWithRank() / (float) lottoMoney.getMoney()) * 100;
    }
}

