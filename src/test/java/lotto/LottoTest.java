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

    @DisplayName("로또에 해당 번호가 있으면 참을 반환한다.")
    @Test
    void isContainLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lotto.isContains(lottoNumber)).isTrue();
    }

    @DisplayName("로또와 매치되는 숫자의 갯수를 반환한다.")
    @Test
    void getCountOfMatch() {
        Lotto lottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoB = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lottoA.countOfMatch(lottoB)).isEqualTo(5);
    }
}
