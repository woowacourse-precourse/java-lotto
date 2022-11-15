package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Generator {
    public static List<Lotto> createLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>(ticketCount);
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = createNumbers();
            lottoTickets.add(new Lotto(numbers));
        }
        return lottoTickets;
    }

    private static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static WinningNumber getWinningNumber() {
        return new WinningNumber();
    }
}
