package lotto;

import lotto.result.RewardEnum;
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
    @DisplayName("로또 번호의 범위는 1~ 45 이다.1")
    @Test
    void createLottoByOverRange1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위는 1~ 45 이다.2")
    @Test
    void createLottoByOverRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 결과 매칭 기능1")
    @Test
    void matchLottoAndWinningNumber1(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lotto.match(winningNumber)).isEqualTo(RewardEnum.WIN_6);
    }

    @DisplayName("로또 번호 결과 매칭 기능2")
    @Test
    void matchLottoAndWinningNumber2(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(lotto.match(winningNumber)).isEqualTo(RewardEnum.WIN_5_BONUS);
    }

}
