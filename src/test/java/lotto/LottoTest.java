package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

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
    @DisplayName("로또번호가 6자리 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
    //입력금액과 관련된 예외테스트
    @DisplayName("입력금액이 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void createMoneyStringCheck(){
        assertThatThrownBy(() -> new UserLotto("aaaa"))
            .isInstanceOf(NoSuchElementException.class);
    }
    @DisplayName("입력금액이 1,000원 단위가 아닐 시 예외가 발생한다")
    @Test
    void createMoneyUnit(){
        assertThatThrownBy(() -> new UserLotto("999"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
    //보너스번호에 관련된 테스트코드
    @DisplayName("보너스 번호가 로또 번호에 들어있으면 예외가 발생한다.")
    @Test
    void createDuplicatedBonusNumberOfLotto() {
        assertThatThrownBy(() -> new LottoBonus(6, List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 45를 넘으면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverSize() {
        assertThatThrownBy(() -> new LottoBonus(46, List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
        }
    @DisplayName("보너스 번호가 1보다 작다면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderSize(){
        assertThatThrownBy(() -> new LottoBonus(0, List.of(1,2,3,4,5,6)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}