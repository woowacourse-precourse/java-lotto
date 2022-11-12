package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BankerTest {
    Banker banker = new Banker();
    int[] victory = new int[2];

    @Test
    void compareCount() {
        Banker banker = new Banker();
        banker.compareCount(victory);
        assertThat(banker.getMap().get(Victory.MATCH3)).isEqualTo(1);
    }

    @Test
    void isBonusCount() {

    }

    @Test
    void correctCount() {
        banker.setWinningNumber(Arrays.asList(1,2,3,4,5,6));
        victory[0] = 6;
        victory[1] = 0;
        assertThat(banker.correctCount(new Lotto(Arrays.asList(1,2,3,4,5,6)))).isEqualTo(victory);
    }

    @Test
    void testCompareCount() {
    }
}