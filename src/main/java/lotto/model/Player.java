package lotto.model;

import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;
import static lotto.util.Constants.NUMBER_COUNTS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<List<Integer>> allPlayerNumbers = new ArrayList<>();

    public Player(int ticketNumber) {
        createAllPlayerNumbers(ticketNumber);
    }

    private void createAllPlayerNumbers(int ticketNumber) {
        do {
            allPlayerNumbers.add(createPlayerNumbers());
        } while (allPlayerNumbers.size() < ticketNumber);
    }

    private static List<Integer> createPlayerNumbers() {
        return createSixRandomUniqueNumbers().stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> createSixRandomUniqueNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, NUMBER_COUNTS));
    }

    public List<List<Integer>> getAllPlayerNumbers() {
        return allPlayerNumbers;
    }

}
