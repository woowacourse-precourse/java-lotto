package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class PrizePolicy {

    final int THREE_MATCH = 3;
    final int FOUR_MATCH = 4;
    final int FIVE_MATCH = 5;
    final int SIX_MATCH = 6;

    final int THREE_MATCH_PRIZE = 5000;
    final int FOUR_MATCH_PRIZE = 50000;
    final int FIVE_MATCH_PRIZE = 1500000;
    final int SIX_MATCH_PRIZE = 2000000000;

    public List<Integer> match = List.of(
            THREE_MATCH,
            FOUR_MATCH,
            FIVE_MATCH,
            SIX_MATCH
    );


    public List<Integer> prize = List.of(
            THREE_MATCH_PRIZE,
            FOUR_MATCH_PRIZE,
            FIVE_MATCH_PRIZE,
            SIX_MATCH_PRIZE
    );

    public List<Integer> count = new ArrayList<>();


    public void increaseCount(int index) {
        initCount();
        Integer num = count.get(index);
        num = num + 1;
        count.add(num, index);
    }

    private void initCount() {
        for (int i = 0; i < 4; i++) {
            count.add(0);
        }
    }
}
