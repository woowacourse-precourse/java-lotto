package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;


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

    @DisplayName("로또 객체 생성")
    @Test
    void createLotto() {
        List<Integer> lottoNumber = Arrays.asList(13, 15, 16, 21, 31, 42);

        Lotto lotto = new Lotto(lottoNumber);

        assertThat(lotto.getLottoNumbers()).contains(13, 15, 16, 21, 31, 42);
    }

    @DisplayName("당첨 로또와 비교해서 얼마나 많은 번호가 맞았는지 확인한다.")
    @Test
    void getCountOfMatch() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        int matchCount = userLotto.getCountOfMatch(winningLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void containBonus() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 5;

        assertThat(userLotto.containBonus(bonus)).isTrue();
    }
}
