package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("로또 번호와 당첨 번호의 일치 개수를 반환한다.")
    @Test
    void 로또_번호_당첨_번호_일치_개수() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning1 = List.of(45, 2, 33, 17, 5, 6);
        assertThat(lotto1.getMatchNumberCount(winning1)).isEqualTo(3);

        Lotto lotto2 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        List<Integer> winning2 = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto2.getMatchNumberCount(winning2)).isEqualTo(0);
    }

    @DisplayName("로또 번호에 보너스 번호가 있는지 여부를 반환한다.")
    @Test
    void 로또_번호_보너스_번호_일치_여부() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus1 = 3;
        assertThat(lotto1.haveBonusNumber(bonus1)).isTrue();

        Lotto lotto2 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        int bonus2 = 1;
        assertThat(lotto2.haveBonusNumber(bonus2)).isFalse();
    }
}
