package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @ParameterizedTest
    @ValueSource(strings = {"4,,3,2,7", ",,,", "2,2,2,", "22,3,2,4,3"})
    @DisplayName("잘못된 형식의 입력 시 예외 발생")
    void invalidWinningLottoInputFormatTest(String input){
        assertThatThrownBy(()->{
            winningLotto = new WinningLotto(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,0,0,0,0,0", "99,8,12,4,48,9", "2,2,2,2,2,3"})
    @DisplayName("Lotto 도메인의 숫자 검증 테스트")
    void invalidLottoTest(String input) {
        assertThatThrownBy(() -> {
            winningLotto = new WinningLotto(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 입력 시 Winning lotto 잘 저장하는지 1")
    void validWinningLottoTest1() {
        winningLotto = new WinningLotto("1,2,3,4,5,6");
        assertThat(winningLotto.getWinningLottoNumbers().getNumbers()).hasSize(6).containsExactlyInAnyOrder(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("정상 입력 시 Winning lotto 잘 저장하는지 2")
    void validWinningLottoTest2() {
        winningLotto = new WinningLotto("38,9,10,23,44,45");
        assertThat(winningLotto.getWinningLottoNumbers().getNumbers()).hasSize(6).containsExactlyInAnyOrder(38,9,10,23,44,45);
    }

}