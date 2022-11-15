package lotto.domain.winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinnerTest {
    LottoWinner lottoWinner;

    @BeforeEach
    void init() {
        lottoWinner = new LottoWinner();
    }

    @DisplayName("숫자 6개와 그 사이는 ,로 구분해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,", "1,2,3", "1234,5", "1,2,3,4,5,", "123456", "1, 2, 3, 4, 5, 6"})
    void 입력_형식_실패_테스트(String input) {
        assertThatThrownBy(() -> lottoWinner.setLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 아닌 입력이 들어오면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,!!", "안,녕,하,세,요,하", "!,!,.,@,%,3"})
    void 문자_입력_테스트(String input) {
        assertThatThrownBy(() -> lottoWinner.setLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위에 벗어난 수가 들어오면 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,64", "11,234,231,23,10,9", "-1,-2,0,1,2,3"})
    void 범위_예외_테스트(String input) {
        assertThatThrownBy(() -> lottoWinner.setLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,3,4,5,6"})
    void 중복_예외_테스트(String input) {
        assertThatThrownBy(() -> lottoWinner.setLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 리스트의 크기가 6이상이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "3,4,5,6,7,8,9,10"})
    void 리스트_크기_테스트(String input) {
        assertThatThrownBy(() -> lottoWinner.setLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 형식으로 테스트에 성공한다.")
    @Test
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void 입력_형식_성공_테스트() {
        String input = "1,2,3,4,5,6";
        lottoWinner.setLotto(input);
        Assertions.assertThat(lottoWinner.getLotto().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
