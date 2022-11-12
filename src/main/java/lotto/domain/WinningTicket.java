package lotto.domain;

import java.util.List;

public class WinningTicket {
    private List<Integer> winnings;
    private int bonusNumber;

    public WinningTicket(List<Integer> winnings, int bonusNumber) {
        this.winnings = winnings;
        this.bonusNumber = bonusNumber;
    }
}
