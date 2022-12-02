package lotto.model.numbers;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerNumber {
    private final List<Integer> playerNumber;

    private PlayerNumber() {
        this.playerNumber = generateLottoNumber();
    }

    public static PlayerNumber createAutoLotto() {
        return new PlayerNumber();
    }

    private List<Integer> generateLottoNumber() {
        Set<Integer> playerNumber = new LinkedHashSet();
        while (playerNumber.size() < NUMBER_COUNT) {
            playerNumber.add((int) (Math.random() * MAX_RANGE) + MIN_RANGE);
        }
        return sort(playerNumber);
    }

    private static ArrayList<Integer> sort(Set<Integer> playerNumber) {
        return playerNumber.stream().sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return playerNumber.toString();
    }
}
