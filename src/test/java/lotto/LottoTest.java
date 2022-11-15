package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
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
    @DisplayName("로또 번호에 1~45사이 숫자가 없으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른 임의의 수가 6개 있는 로또 번호가 생성된다.")
    @Test
    void createLotto() {
        // given
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // when
        Lotto lotto = new Lotto(randomNumbers);
        List<Integer> lottoNumbers = lotto.getNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
        assertThat(lottoNumbers.stream().allMatch(number -> 1 <= number && number <= 45)).isTrue();

    }

    @DisplayName("오름차순으로 정렬된 로또 번호가 생성된다.")
    @Test
    void createLottoWithAscendingOrder() {
        // given
        List<Integer> randomNumbers = Arrays.asList(6, 5, 4, 3, 2, 1);

        // when
        Lotto lotto = new Lotto(randomNumbers);
        List<Integer> lottoNumbers = lotto.getNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);
        assertThat(lottoNumbers.stream().allMatch(number -> 1 <= number && number <= 45)).isTrue();
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
