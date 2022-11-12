package lotto.domain;

import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 숫자가 6개이어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호에 특정 수가 있으면 true를 반환한다.")
    @Test
    void hasNumberReturnTrue() {
        Lotto lotto = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

        boolean result = lotto.hasNumber(new LottoNumber(3));

        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호에 특정 수가 없으면 false를 반환한다.")
    @Test
    void hasNumberReturnFalse() {
        Lotto lotto = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));

        boolean result = lotto.hasNumber(new LottoNumber(10));

        assertThat(result).isFalse();
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
