package lotto.model.numbers;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_COUNT));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    @Override
    public String toString() {
        return playerNumber.toString();
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
