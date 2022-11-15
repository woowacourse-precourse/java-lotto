package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

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

    @DisplayName("로또 번호에 1 미만인 숫자가 있다면 예외가 발생한다")
    @Test
    void createLottoByOutOfRangeNumberWithUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 미만인 숫자가 있다면 예외가 발생한다")
    @Test
    void createLottoByOutOfRangeNumberWithOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 번호가 입력된다면 로또는 정상적으로 생성된다.")
    @Test
    void createLottoByRightNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 15, 32, 44, 45));
        assertInstanceOf(Lotto.class, lotto);
    }

    @DisplayName("로또를 서로 비교했을 때 매칭되는 숫자의 수를 올바르게 반환하는지 확인.")
    @Test
    void lottoMatchingCountTest() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 6, 10, 40, 45));

        // when
        int matchingNumberCount = lotto1.getMatchingNumberCount(lotto2);
        
        // then
        assertEquals(3, matchingNumberCount);
    }

    @DisplayName("로또 번호에 특정 숫자가 포함되는지 여부를 올바르게 반환하는지 확인.")
    @Test
    void lottoExistsMatchingNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when
        boolean exists = lotto.existsMatchingNumber(bonusNumber);

        // then
        assertEquals(true, exists);
    }
}
