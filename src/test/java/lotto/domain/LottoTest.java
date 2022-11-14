package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    void 로또_6개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(6, count);
    }

    @Test
    void 로또_5개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(5, count);
    }

    @Test
    void 로또_4개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(4, count);
    }

    @Test
    void 로또_3개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(3, count);
    }

    @Test
    void 로또_2개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(2, count);
    }

    @Test
    void 로또_1개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = List.of(1, 7, 8, 9, 10, 11);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(1, count);
    }

    @Test
    void 로또_0개_같은지_테스트() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = List.of(12, 7, 8, 9, 10, 11);

        //when
        int count = lotto.compare(winNumber);

        //then
        assertEquals(0, count);
    }
}
