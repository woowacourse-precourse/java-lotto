package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    @DisplayName("보너스 번호가 로또 번호와 중복이 있으면 예외가 발생한다.")
    @Test
    void createLottoAndBonusWithDuplicatedNumber() {
        Lotto.bonusNumber = 6;
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .exceptionBonusNumberByDuplicatedLotto(Lotto.bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 갯수가 6개 미만일 경우 예외가 발생한다.")
    @Test
    void createLottoLessThanSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45사이의 값이 아닐 경우 예외가 발생한다.")
    @Test
    void createOutOfRangeOfLottoNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45사이의 값이 아닐 경우 예외가 발생한다.")
    @Test
    void createOutOfRangeOfBonusNumber() {
        final int bonusNumber = 0;
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .exceptionBonusNumberOutOfRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 수익률은 소수점 둘째 자리에서 반올림하여 소수점 첫째 자리까지 출력한다.")
    @Test
    void roundUpTotalYieldToSecondDigit() {
        final double yield = 62.55;
        assertThat(String.format("%.1f", yield)).isEqualTo("62.6");
    }
}
/**
 * - [o] 당첨 번호 및 보너스 번호 입력 기능
 * <p>
 * 총 수익률은 소수점 둘째 자리에서 반올림하여 소수점 첫째 자리까지 출력한다.
 * <p>
 * - [o] 당첨 통계 계산 기능
 * - 3개 일치
 * - 4개 일치
 * - 5개 일치
 * - 보너스 볼 일치 여부
 * - 6개 일치
 * <p>
 * - [o] 총 수익률 계산 기능
 * - Enum 클래스로 구현
 */