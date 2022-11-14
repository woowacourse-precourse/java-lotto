package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("정렬된 로또 번호 문자열로 변환")
    @Test
    void createLottoNumbersToString() {
        assertThat(new Lotto(List.of(1, 4, 6, 5, 2, 3)).toString())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6).toString());
    }

    @DisplayName("동일한 로또 번호 개수 반환")
    @Test
    void countSameNumber() {
        Lotto lotto = new Lotto(List.of(1, 2 ,3 ,4 ,5 ,6));
        Lotto lotto1 = new Lotto(List.of(1, 3, 4, 5, 6, 8));
        assertThat(lotto.countSameNumber(lotto1, 9))
                .isEqualTo(5);
    }
}
