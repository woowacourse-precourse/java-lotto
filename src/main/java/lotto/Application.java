package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class Application {
    public static void main(String[] args) {
        String payment = Input.submit(ENTER_PURCHASE_PRICE);
        try {
            Integer purchasePrice = Convertor.getNumericValue(payment);
            Validator.checkIfInThousands(payment);
            Integer purchaseQuantity = purchasePrice / UNIT_PRICE;

            List<List<Integer>> lottoTickets = new ArrayList<>();
            for (int i = 0; i < purchaseQuantity; i++) {
                Lotto lotto = new Lotto(Numbers.generate());
                lottoTickets.add(lotto.getLottoNumbers());
            }
            Output.purchaseSuccessful(purchasePrice, lottoTickets);

            // Winner 클래스에 다시 넣어야 할 듯
            String winningNumbers = Input.submit(ENTER_WINNING_NUMBERS);
            List<Integer> winningNumbersConverted =  Convertor.separate(winningNumbers);
            String bonusNumber = Input.submit(ENTER_BONUS_NUMBER);
            Integer bonusNumberConverted = Convertor.getNumericValue(bonusNumber);
            Validator.checkIfBonusNumberIncludedInWinningNumbers(
                    winningNumbersConverted,
                    bonusNumberConverted
            );

            List<Integer> profits = new ArrayList<>();
            for (List<Integer> myLotto : lottoTickets) {
                Matcher matcher = new Matcher(
                        myLotto,
                        winningNumbersConverted,
                        bonusNumberConverted
                );
                Integer prizeMoney = Ranks.getPrizeMoneyBy(
                        matcher.getMatchingWinningNumberCount(),
                        matcher.getMatchingBonusNumberCount()
                );
                profits.add(prizeMoney);
            }

            Result matchingResult = new Result(profits);
            Output.statistics(purchasePrice, matchingResult.getStatistics());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
