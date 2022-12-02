package lotto.model.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerNumbers {

    private final List<PlayerNumber> playerNumbers;

    private PlayerNumbers(int ticketNumber) {
        List<PlayerNumber> playerNumbers = collectPlayerNumbers(ticketNumber);
        this.playerNumbers = playerNumbers;
    }

    public static PlayerNumbers issueLottoByTickets(int ticketNumber) {
        return new PlayerNumbers(ticketNumber);
    }

    private List<PlayerNumber> collectPlayerNumbers(int ticketNumber) {
        List<PlayerNumber> playerNumbers = new ArrayList<>();
        for (int i = 0; i < ticketNumber; i++) {
            playerNumbers.add(PlayerNumber.createAutoLotto());
        }
        return playerNumbers;
    }

    public List<PlayerNumber> getPlayerNumbers() {
        return Collections.unmodifiableList(playerNumbers);
    }
}
