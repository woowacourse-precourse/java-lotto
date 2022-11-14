package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
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

}