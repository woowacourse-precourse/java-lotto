package lotto.domain;

import static lotto.util.Constants.NUMBER_COUNTS;
import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private List<List<Integer>> allPlayerNumbers = new ArrayList<>();

    public Player(int ticketNumber) {
        createAllPlayerNumbers(ticketNumber);
    }

    public List<List<Integer>> getAllPlayerNumbers() {
        return allPlayerNumbers;
    }

    private void createAllPlayerNumbers(int ticketNumber) {
        do {
            allPlayerNumbers.add(createPlayerNumbers());
        } while (allPlayerNumbers.size() < ticketNumber);
    }

    private static List<Integer> createPlayerNumbers() {
        return sortInAscendingOrders(createSixRandomUniqueNumbers());
    }

    private static List<Integer> createSixRandomUniqueNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, NUMBER_COUNTS));
    }

    private static List<Integer> sortInAscendingOrders(List<Integer> playerNumbers) {
        Collections.sort(playerNumbers);
        return playerNumbers;
    }
}
