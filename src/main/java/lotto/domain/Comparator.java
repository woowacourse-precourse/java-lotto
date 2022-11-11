package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Comparator {
    private final List<List<Integer>> tickets;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Comparator(
            List<List<Integer>> tickets,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }



}
