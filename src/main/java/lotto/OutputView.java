package lotto;

public class OutputView {

    private static final String NUMBER_MATCHES_MESSAGE = "%s개 일치 ";
    private static final String WINNING_REVENUE_MESSAGE = "(%,d원)";
    private static final String WINNING_SECOND_PLACE_REVENUE_MESSAGE = "%s개 일치, 보너스 볼 일치 ";
    private static final String MATCHES_COUNT_MESSAGE = " - %s개";

    private static final String LOTTERY_YIELD_MESSAGE = "총 수익률은  %.1f" + "%%입니다.";

    public void showLottoNumbers(Player player) {
        System.out.println(player.playerLotto.size() + "개를 구매했습니다.");
        int lottoCount = player.playerLotto.size();
        for (int idx=0; idx<lottoCount; idx++) {
            Lotto lotto = player.playerLotto.get(idx);
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void showBonusNumber(Player player, int idx) {
        System.out.println(player.playerLotto.get(idx).getBonusNumber());
    }

    public void showLotteryResults(Player player) {
        showLottoResultMessage(Rewards.FIFTH_PLACE, player.fifthPlace);
        showLottoResultMessage(Rewards.FOURTH_PLACE, player.fourthPlace);
        showLottoResultMessage(Rewards.THIRD_PLACE, player.thirdPlace);
        showLottoResultMessage(Rewards.SECOND_PLACE, player.secondPlace);
        showLottoResultMessage(Rewards.FIRST_PLACE, player.firstPlace);
    }

    public void showLotteryYield(Player player) {
        double lotteryYield = player.getLotteryYield();
        System.out.println(String.format(LOTTERY_YIELD_MESSAGE, lotteryYield));
    }

    private void showLottoResultMessage(Rewards reward, int matchingNumberCount) {
        if (!reward.isBonusNumberMatches) {
            System.out.println(
                    String.format(NUMBER_MATCHES_MESSAGE , reward.matchingNumberCount)
                            + String.format(WINNING_REVENUE_MESSAGE, reward.reward)
                            + String.format(MATCHES_COUNT_MESSAGE, matchingNumberCount));
        }
        System.out.println(
                String.format(WINNING_SECOND_PLACE_REVENUE_MESSAGE , reward.matchingNumberCount)
                        + String.format(WINNING_REVENUE_MESSAGE, reward.reward)
                        + String.format(MATCHES_COUNT_MESSAGE, matchingNumberCount));
    }

}
