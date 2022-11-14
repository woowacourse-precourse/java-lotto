package view;

import lotto.Lotto;
import lotto.Player;
import lotto.Rewards;

public class OutputView {

    private static final String NUMBER_MATCHES_MESSAGE = "%s개 일치 ";
    private static final String WINNING_REVENUE_MESSAGE = "(%,d원)";
    private static final String WINNING_SECOND_PLACE_REVENUE_MESSAGE = "%s개 일치, 보너스 볼 일치 ";
    private static final String MATCHES_COUNT_MESSAGE = " - %s개";
    private static final String LOTTERY_YIELD_MESSAGE = "총 수익률은 %.1f" + "%%입니다.";
    private static final String LOTTERY_STATISTICS_MESSAGE = "당첨 통계 \n---";

    public static void showLottoNumbers(Player player) {
        int lottoCount = player.getLottery().size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        for (int idx = 0; idx < lottoCount; idx++) {
            Lotto lotto = player.getLottery().get(idx);
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void showLotteryResults(Player player) {
        System.out.println(LOTTERY_STATISTICS_MESSAGE);
        showLottoResultMessage(Rewards.FIFTH_PLACE, player.getFifthPlace());
        showLottoResultMessage(Rewards.FOURTH_PLACE, player.getFourthPlace());
        showLottoResultMessage(Rewards.THIRD_PLACE, player.getThirdPlace());
        showLottoResultMessage(Rewards.SECOND_PLACE, player.getSecondPlace());
        showLottoResultMessage(Rewards.FIRST_PLACE, player.getFirstPlace());
    }

    public static void showLotteryYield(Player player) {
        double lotteryYield = player.getLotteryYield();
        System.out.println(String.format(LOTTERY_YIELD_MESSAGE, lotteryYield));
    }

    private static void showLottoResultMessage(Rewards reward, int matchingNumberCount) {
        if (reward == Rewards.SECOND_PLACE && reward.isBonusNumberMatches()) {
            System.out.println(
                    String.format(WINNING_SECOND_PLACE_REVENUE_MESSAGE, reward.getMatchingNumberCount())
                            + String.format(WINNING_REVENUE_MESSAGE, reward.getReward())
                            + String.format(MATCHES_COUNT_MESSAGE, matchingNumberCount));
            return;
        }
        System.out.println(
                String.format(NUMBER_MATCHES_MESSAGE, reward.getMatchingNumberCount())
                        + String.format(WINNING_REVENUE_MESSAGE, reward.getReward())
                        + String.format(MATCHES_COUNT_MESSAGE, matchingNumberCount));
    }
}
