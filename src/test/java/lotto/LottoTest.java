package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

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

    @DisplayName("로또 번호 비교하기_1등")
    @Test
    void compareNumbers_1st() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto answer = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Lotto.compareNumbers(answer, lotto))
                .isEqualTo(6);
    }

    @DisplayName("로또 번호 비교하기_2등")
    @Test
    void compareNumbers_2nd() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto answer = new Lotto(List.of(1,2,3,4,5,7));
        assertThat(Lotto.compareNumbers(answer, lotto))
                .isEqualTo(5);
        assertThat(Lotto.hasBonusNumber(6, lotto)).isTrue();
    }

    @DisplayName("로또 번호 비교하기_3등")
    @Test
    void compareNumbers_3rd() {
        Lotto lotto = new Lotto(List.of(5,9,12,13,26,37));
        Lotto answer = new Lotto(List.of(5,9,13,15,26,37));
        assertThat(Lotto.compareNumbers(answer, lotto))
                .isEqualTo(5);
        assertThat(Lotto.hasBonusNumber(1, lotto)).isFalse();
    }

    @DisplayName("로또 번호 비교하기_4등")
    @Test
    void compareNumbers_4th() {
        Lotto lotto = new Lotto(List.of(2,14,17,21,35,36));
        Lotto answer = new Lotto(List.of(1,14,17,35,36,42));
        assertThat(Lotto.compareNumbers(answer, lotto))
                .isEqualTo(4);
    }

    @DisplayName("로또 번호 비교하기 5등")
    @Test
    void compareNumbers_5th() {
        Lotto lotto = new Lotto(List.of(11,16,17,25,36,44));
        Lotto answer = new Lotto(List.of(2,5,16,25,26,44));
        assertThat(Lotto.compareNumbers(answer, lotto))
                .isEqualTo(3);
    }

    @DisplayName("로또 번호 범위를 벗어나면 예외")
    @Test
    void createByInvalidScope() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 중복일 경우 예외_1")
    @Test
    void createByDuplicationBonusNumberOne() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> Lotto.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 중복일 경우 예외_2")
    @Test
    void createByDuplicationBonusNumberTwo() {
        Lotto lotto = new Lotto(List.of(13,14,15,16,17,18));
        int bonusNumber = 15;
        assertThatThrownBy(() -> Lotto.validateBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
