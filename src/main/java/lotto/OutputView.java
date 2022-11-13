package lotto;

public class OutputView {

    private static final String NUMBER_MATCHES_MESSAGE = "%s개 일치 ";
    private static final String WINNING_REVENUE_MESSAGE = "(%,d원)";
    private static final String WINNING_SECOND_PLACE_REVENUE_MESSAGE = "%s개 일치, 보너스 볼 일치 ";
    private static final String MATCHES_COUNT_MESSAGE = " - %s개";

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

    public static void showLottoResultMessage(Rewards reward) {
        if (reward.matchingNumberCount == 5 && reward.isBonusNumberMatches == true) {
            System.out.println(
                    String.format(WINNING_SECOND_PLACE_REVENUE_MESSAGE , reward.matchingNumberCount)
                            + String.format(WINNING_REVENUE_MESSAGE, reward.reward)
                            + String.format(MATCHES_COUNT_MESSAGE, reward.matchingNumberCount));
        }
        System.out.println(
                String.format(NUMBER_MATCHES_MESSAGE , reward.matchingNumberCount)
                        + String.format(WINNING_REVENUE_MESSAGE, reward.reward)
                        + String.format(MATCHES_COUNT_MESSAGE, reward.matchingNumberCount));
    }
}
