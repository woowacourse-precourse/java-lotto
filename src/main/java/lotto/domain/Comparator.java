package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class Comparator {
    private final List<List<Integer>> tickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final LinkedHashMap<Prize, Integer> winningTickets = new LinkedHashMap<>();

    public Comparator(
            List<List<Integer>> tickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        for (Prize prize: Prize.values()) {
            this.winningTickets.put(prize, 0);
        }
    }

    private void countSameNumber(int same, boolean bonus) {
        if (same == 3 && !bonus) {
            int count = winningTickets.get(Prize.FIFTH);
            this.winningTickets.put(Prize.FIFTH, count + 1);
            return;
        }
        if (same == 4 && !bonus) {
            int count = winningTickets.get(Prize.FOURTH);
            this.winningTickets.put(Prize.FOURTH, count + 1);
            return;
        }
        if (same == 5 && !bonus) {
            int count = winningTickets.get(Prize.THIRD);
            this.winningTickets.put(Prize.THIRD, count + 1);
            return;
        }
        if (same == 5) {
            int count = winningTickets.get(Prize.SECOND);
            this.winningTickets.put(Prize.SECOND, count + 1);
            return;
        }
        int count = winningTickets.get(Prize.FIRST);
        this.winningTickets.put(Prize.FIRST, count + 1);
    }

}
