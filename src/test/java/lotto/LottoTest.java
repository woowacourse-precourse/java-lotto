package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능


    @Test
    void createLottoByOutOfUpperBound() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 56, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        ;
    }

    @Test
    void createLottoByOutOfLowerBound() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        ;
    }

    @Test
    void ContainTest() {
        assertTrue(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).have(new LottoNumber(3)));
        assertFalse(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)).have(new LottoNumber(7)));
    }

    @Test
    void numberOfMatchesTest() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 4, 5, 8, 10, 11));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        Lotto lotto4 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertEquals(lotto1.countNumberOfMatchesWith(lotto2), 3);
        assertEquals(lotto2.countNumberOfMatchesWith(lotto3), 6);
        assertEquals(lotto2.countNumberOfMatchesWith(lotto4), 0);
    }


}
