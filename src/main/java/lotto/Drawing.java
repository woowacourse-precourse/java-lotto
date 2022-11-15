package lotto;

import java.util.*;

public class Drawing {
    private Result result;

    public Drawing(Buyer buyer, WinningNumber winningNumber) {
        result = new Result();
        List<Lotto> lottoTickets = buyer.getLottoTickets();
        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int count = countNumber(lottoNumbers, winningNumber.getNumbers());
            boolean bonus = isBonus(lottoNumbers, winningNumber.getBonusNumber());
            result.addWinningHistory(calculateRank(count, bonus));
        }
    }

    private static int countNumber(List<Integer> lottoNumbers, List<Integer> winningNumber) {
        int count = 0;
        for (Integer n : lottoNumbers) {
            if (winningNumber.contains(n)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean isBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private static Rank calculateRank(int count, boolean bonus) {
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5 && bonus) {
            return Rank.SECOND;
        }
        if (count == 5) {
            return Rank.THIRD;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return null;
    }

    public Result getResult() {
        return result;
    }
}
