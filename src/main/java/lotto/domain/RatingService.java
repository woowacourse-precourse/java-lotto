package lotto.domain;

import java.util.List;
import java.util.Map;

public class RatingService {

    public static void service(Result result, List<Lotto> tickets, WinningNumber winningNumber) {
        for (Lotto ticket : tickets) {
            Rating rating = matchRating(ticket, winningNumber);
            result.updateResult(rating);
        }
    }

    public static Rating matchRating(Lotto ticket, WinningNumber winningNumber) {
        int count = countMatchedNumber(ticket, winningNumber);
        boolean isMatchedByBonus = checkBonusNumber(ticket, winningNumber);
        return Rating.getRating(count, isMatchedByBonus);
    }

    public static int countMatchedNumber(Lotto ticket, WinningNumber winningNumber) {
        return (int) ticket.getNumbers()
                .stream()
                .filter(number -> winningNumber.getNumber().contains(number))
                .count();
    }

    public static boolean checkBonusNumber(Lotto ticket, WinningNumber winningNumber) {
        return ticket.getNumbers().contains(winningNumber.getBonus());
    }
}
