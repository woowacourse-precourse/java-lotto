package lotto;

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
    @DisplayName("당첨 번호화 로또 번호 일치 갯수 계산하여 반환한다.")
    @Test
    void getCompareResultMethodTest(){
        Lotto playerLotto = new Lotto(Arrays.asList(1,2,3,7,9,11));
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        assertThat(playerLotto.getCompareResult(winningNumbers)).isEqualTo(3);
    }
    @DisplayName("보너스 번호가 포함되어 있는지 확인한다.")
    @Test
    void isBonusContained(){
        Lotto playerLotto = new Lotto(Arrays.asList(1,2,3,7,9,11));
        int bonusNumber = 7 ;
        assertThat(playerLotto.isBonusContained(bonusNumber)).isTrue();
    }
}
