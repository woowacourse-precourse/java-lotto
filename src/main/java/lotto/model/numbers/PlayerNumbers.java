package lotto.model.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return Stream.generate(PlayerNumber::createAutoLotto).limit(ticketNumber).collect(Collectors.toList());
    }

    public List<PlayerNumber> getPlayerNumbers() {
        return playerNumbers;
    }
}
