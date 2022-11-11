package lotto;

import java.util.List;

public class LottoCalculator {

    public static int calculateRank(Lotto winningNumber, Bonus bonus, Lotto lottoTicket) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        List<Integer> lottoTicketNumbers = lottoTicket.getNumbers();
        int bonusNumber = bonus.getNumber();

        long matchCount = match(lottoTicketNumbers, winningNumbers);

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && containsBonusNumber(lottoTicketNumbers, bonusNumber)) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return -1;
    }

    private static long match(List<Integer> lottoTicketNumbers, List<Integer> winningNumbers) {
        return lottoTicketNumbers.stream().filter(winningNumbers::contains).count();
    }

    private static boolean containsBonusNumber(List<Integer> lottoTicketNumbers, int bonusNumber) {
        return lottoTicketNumbers.contains(bonusNumber);
    }
}
