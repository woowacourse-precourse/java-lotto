package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DomainTest {
    static Domain domain = new Domain();

    @DisplayName("구입 가격 형식 검증 테스트")
    @Test
    void validatePriceInputTest() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("9");
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("3000a");
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("3001");
        });
    }

    @DisplayName("로또 당첨 번호 유효성 검사 테스트")
    @Test
    void validateWinningNumberInputTest() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateWinningNumberInput("1,2,3,4,5,5");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateWinningNumberInput("1,2,3,4,5,6,7");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateWinningNumberInput("1,-1,3,4,5,6");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validateWinningNumberInput("a,2,3,4,5,6");
        });

        domain.validateWinningNumberInput("1,2,3,4,5,6");
    }

    @DisplayName("input을 Integer List 형태로 trim 테스트")
    @Test
    void trimLottoNumberInputTest() {
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(domain.trimLottoNumberInput("1,2,3,4,5,6").containsAll(result));

        result = Arrays.asList(11, 22, 33, 44, 43, 42);
        assertThat(domain.trimLottoNumberInput("11,22,33,44,43,42").containsAll(result));
    }

    @DisplayName("등수에 따른 수익 계산 테스트")
    @Test
    void getRewardTest() {
        assertThat(domain.getReward(1) == 2000000000);
        assertThat(domain.getReward(2) == 30000000);
        assertThat(domain.getReward(3) == 1500000);
        assertThat(domain.getReward(4) == 50000);
        assertThat(domain.getReward(5) == 5000);
    }

    @DisplayName("각 등수별 개수 반환 메서드 테스트")
    @Test
    void getRankListTest() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = -1;
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 1, 0, 0, 0, 0)));

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 1, 0, 1, 0, 0)));

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        bonus = 6;
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 1, 1, 1, 0, 0)));

        bonus = -1;
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 1, 1, 1, 1, 0)));

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 9, 7, 8)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 1, 1, 1, 1, 1)));

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 2, 1, 1, 1, 1)));

        lottos.add(new Lotto(Arrays.asList(45, 44, 43, 42,41, 40)));
        assertThat(domain.getRankList(lottos, winningNumbers, bonus)
                .containsAll(Arrays.asList(0, 2, 1, 1, 1, 1)));
    }
}
