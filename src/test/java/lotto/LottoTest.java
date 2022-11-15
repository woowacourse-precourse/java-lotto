package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 0, 0, 0, 0, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 0, 0, 0, 0, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO 생성자 수정해 보기
    @DisplayName("1000으로 나눈 몫을 반환, 1000으로 나누어떨어지지 않으면 IllegalArgumentExcpetion 발생")
    @Test
    void lottoCount() {
        Lotto lotto = new Lotto(List.of(0, 1, 2, 3, 4, 5));
        assertThatThrownBy(() -> lotto.lottoCount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트를 오름차순 정렬")
    @Test
    void sortLottoNumberAscending() {
        Lotto lotto = new Lotto(List.of(0, 1, 2, 3, 4, 5));
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.sortLottoNumberAscending(List.of(5, 6, 2, 1, 3, 4)));
    }

}
