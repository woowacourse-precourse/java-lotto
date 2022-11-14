package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareTest {

    @Test
    void compareLotto() {
        Compare compare = new Compare();
        compare.setWinningLotto(List.of(1,2,3,4,5,6));

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Rank rank = compare.compareLotto(lotto);

        System.out.println(rank.getNotification());

    }
}