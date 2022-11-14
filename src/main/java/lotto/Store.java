package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private static final String QUANTITY_MESSAGE = "개를 구매했습니다.";

    public List<List<Integer>> makeLottoTickets(int quantity, List<List<Integer>> tickets) {
        System.out.println(quantity + QUANTITY_MESSAGE);
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //Collections.sort(numbers);
            tickets.add(new ArrayList<>(numbers));
        }
        System.out.println();  // 출력형식에 맞도록 줄바꿈 삽입
        return tickets;
    }
}
