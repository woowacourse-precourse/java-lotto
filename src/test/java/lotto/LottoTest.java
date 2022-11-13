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

    @DisplayName("로또 번호를 형식에 맞는 문자열 형태로 반환한다.")
    @Test
    void 로또_번호_문자열() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String str1 = lotto1.toStringLotto();
        assertThat(str1).isEqualTo("[1, 2, 3, 4, 5, 6]");

        Lotto lotto2 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        String str2 = lotto2.toStringLotto();
        assertThat(str2).isEqualTo("[8, 21, 23, 41, 42, 43]");
    }
}
