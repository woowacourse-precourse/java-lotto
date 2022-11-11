package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class Application {
    private final static String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final static String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        String payment = Input.submit(ENTER_PURCHASE_PRICE);
        try {
            Input.validateIfNumeric(payment);
            Input.validateIfInThousands(payment);

            Integer purchasePrice = Integer.valueOf(payment);
            Integer purchaseQuantity = purchasePrice / UNIT_PRICE;

            List<List<Integer>> lottoTickets = new ArrayList<>();
            for (int i = 0; i < purchaseQuantity; i++) {
                Lotto lotto = new Lotto(Numbers.generate());
                lottoTickets.add(lotto.getLottoNumbers());
            }
            Output.purchaseSuccessful(purchasePrice, lottoTickets);

            String winningNumbers = Input.submit(ENTER_WINNING_NUMBERS);
            String bonusNumber = Input.submit(ENTER_BONUS_NUMBER);
            Winner winner = new Winner(winningNumbers, bonusNumber);

            List<Integer> profits = new ArrayList<>();
            for (List<Integer> lotto : lottoTickets) {
                Matcher matcher = new Matcher(lotto, winner.getWinningNumbers(), winner.getBonusNumber());
                int matchingWinningNumberCount = matcher.getMatchingWinningNumberCount();
                int matchingBonusNumberCount = matcher.getMatchingBonusNumberCount();
                Prize prize = new Prize(matchingWinningNumberCount, matchingBonusNumberCount);
                profits.add(prize.getMoney());
            }

            Roi roi = new Roi(profits, purchasePrice);
            Output.statistics(purchasePrice, roi.getStatistics());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
