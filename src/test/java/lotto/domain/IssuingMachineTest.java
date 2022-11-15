package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssuingMachineTest {
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;

    private IssuingMachine issuingMachine;

    @BeforeEach
    void setUp() {
        issuingMachine = new IssuingMachine();
    }

    @AfterEach
    void tearDown() {
        issuingMachine = null;
    }

    @Test
    void makeLotteryListLengthTest() {
        List<Lotto> lottos = issuingMachine.makeLotteryList(3);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            org.assertj.core.api.Assertions.assertThat(numbers.size()).isEqualTo(6);
        }
    }

    @Test
    void makeLotteryListDuplicationTest() {
        List<Lotto> lottos = issuingMachine.makeLotteryList(3);
        for(Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            org.assertj.core.api.Assertions.assertThat(uniqueNumbers.size()).isEqualTo(6);
        }
    }

    @Test
    void makeLotteryListRangeTest() {
        List<Lotto> lottos = issuingMachine.makeLotteryList(3);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            assertAll(
                    () -> org.assertj.core.api.Assertions.assertThat(max).isLessThanOrEqualTo(MAX_NUM),
                    () -> org.assertj.core.api.Assertions.assertThat(min).isGreaterThanOrEqualTo(MIN_NUM)
            );
        }
    }
}