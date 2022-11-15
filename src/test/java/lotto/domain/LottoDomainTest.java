package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDomainTest {
    private Lotto lotto;

    @BeforeEach
    void init() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        this.lotto = new Lotto(list);
    }

    @Test
    @DisplayName("numbers list 출력 메서드 테스트")
    void testToString() {
        System.out.println(lotto.toString());
    }


    @Test
    @DisplayName("contains 메서드 테스트_true")
    void contains_true() {
        boolean isContained = lotto.contains(1);
        assertThat(isContained).isTrue();
    }

    @Test
    @DisplayName("contains 메서드 테스트_false")
    void contains_false() {
        boolean isContained = lotto.contains(10);
        assertThat(isContained).isFalse();
    }

    @Test
    @DisplayName("List -> Set 메서드 기능 테스트")
    void toSet() {
        Set<Integer> integers = lotto.toSet();
        assertThat(integers).isInstanceOf(Set.class);
    }
}