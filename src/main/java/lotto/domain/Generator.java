package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class Generator {
    private final List<List<Integer>> tickets;

    public Generator(int count) {
        tickets = new ArrayList<>();
        generateTickets(tickets, count);
    }


    public List<List<Integer>> getTickets() {
        return tickets;
    }

    private void generateTickets(List<List<Integer>> tickets, int count) {
        for (int i = 0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
            tickets.add(sortedNumbers);
        }
    }
}
