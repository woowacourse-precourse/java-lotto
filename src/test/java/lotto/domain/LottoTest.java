package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoResult.LOSING;
import static lotto.domain.LottoResult.THREE;
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
    @DisplayName("로또 번호에 45를 초과하는 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1미만인 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 받아오기")
    @Test
    void createLottoAndGet() {
        Lotto testResult = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(testResult.get()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 결과 디폴트 값 받아오기")
    @Test
    void createLottoResultGet() {
        Lotto testResult = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(testResult.getLottoResult()).isEqualTo(LOSING);
    }

    @DisplayName("로또 결과 설정 및 받아오기")
    @Test
    void createLottoResultSetAndGet() {
        Lotto testResult = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testResult.setLottoResult(THREE);
        assertThat(testResult.getLottoResult()).isEqualTo(THREE);
    }
}
