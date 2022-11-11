package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final static String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final static String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        try {
            String price = Input.submit(ENTER_PURCHASE_PRICE);
            Purchase consumerSpending = new Purchase(price);
            Integer purchaseQuantity = consumerSpending.getPrice() / 1000;

            List<List<Integer>> lottos = new ArrayList<>();
            for (int index = 0; index < purchaseQuantity; index++) {
                Lotto lotto = new Lotto(Generator.LottoNumbers());
                lottos.add(lotto.getLottoNumbers());
            }
            Output.purchaseSuccessful(consumerSpending.getPrice(), lottos);

            String winningNumbers = Input.submit(ENTER_WINNING_NUMBERS);
            String bonusNumber = Input.submit(ENTER_BONUS_NUMBER);
            Winner winner = new Winner(winningNumbers, bonusNumber);

            List<Integer> profits = new ArrayList<>();
            for (List<Integer> lotto : lottos) {
                Matcher matcher = new Matcher(lotto, winner.getWinningNumbers(), winner.getBonusNumber());
                int matchingWinningNumberCount = matcher.getMatchingWinningNumberCount();
                int matchingBonusNumberCount = matcher.getMatchingBonusNumberCount();
                Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
                profits.add(prize.getMoney());
            }

            Roi roi = new Roi(profits, consumerSpending.getPrice());
            Output.statistics(consumerSpending.getPrice(), roi.getStatistics());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
