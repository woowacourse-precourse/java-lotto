package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {
    int numberOfTickets;
    NumberGenerator(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}

