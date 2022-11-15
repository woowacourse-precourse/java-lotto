package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {

    private List<Integer> numbers;
    private List<Integer> lotto;

    @BeforeEach
    void init() {
        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
    }

    @Test
    void 예상_랭크_생성_확인_SECOND() {
        RankCalculator rankCalculator = new RankCalculator();

        Rank rank = rankCalculator.calculate(numbers,lotto,6);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 예상_랭크_생성_확인_THIRD() {
        RankCalculator rankCalculator = new RankCalculator();

        Rank rank = rankCalculator.calculate(numbers,lotto,8);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

}