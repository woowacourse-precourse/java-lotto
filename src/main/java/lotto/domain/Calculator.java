package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public static List<Ranking> calculateTicketRankings(LottoTicket lottoTicket, WinningBonusNumber winningBonusNumber) {
        List<Ranking> rankings = new ArrayList<>();
        List<Lotto> tickets = lottoTicket.getLottoTickets();

        for (int i = 0; i < tickets.size(); i++) {
            // 각 티켓과 당첨번호를 대조해서 몇 등 인지 결과를 구한 뒤 rankings 리스트에 넣는다.
            Lotto lotto = tickets.get(i);
            Ranking ranking = calculateRanking(lotto, winningBonusNumber);

            rankings.add(ranking);
        }

        return rankings;
    }

    private static Ranking calculateRanking(Lotto nowLotto, WinningBonusNumber winningBonusNumber) {
        List<Integer> winningNumbers = winningBonusNumber.getWinningNumbers();
        int bonusNumber = winningBonusNumber.getBonusNumber();

        int sameNumbers = countSameNumbers(nowLotto, winningNumbers);
        boolean hasBonusNumber = nowLotto.getNumbers().contains(bonusNumber);

        return Ranking.matchRanking(sameNumbers, hasBonusNumber);
    }

    private static int countSameNumbers(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) count++;
        }

        return count;
    }
}
