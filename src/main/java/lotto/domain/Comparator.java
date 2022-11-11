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



}
