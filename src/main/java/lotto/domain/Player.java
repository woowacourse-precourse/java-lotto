package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class Player {

    private static final List<List<Integer>> playerNumbers = new ArrayList<>();

    public Player(int ticketNumber) {
        createAllPlayerNumbers(ticketNumber);
    }

    public List<List<Integer>> get() {
        return playerNumbers;
    }

    private static void createAllPlayerNumbers(int ticketNumber) {
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> playerNumber = createPlayerNumbers();
            playerNumbers.add(playerNumber);
            OutputView.printPlayerNumbers(playerNumber);
        }
    }

    private static List<Integer> createPlayerNumbers() {
        return sortInAscendingOrders(createSixRandomUniqueNumbers());
    }

    private static List<Integer> createSixRandomUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> sortInAscendingOrders(List<Integer> playerNumbers) {
        Collections.sort(playerNumbers);
        return playerNumbers;
    }
}
