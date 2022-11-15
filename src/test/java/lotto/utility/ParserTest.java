package lotto.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    @DisplayName("로또 당첨 번호 입력 검증 : 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputIsNotNumbers() {
        assertThatThrownBy(() -> Parser.numbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 검증 : 형식에 어긋나면 예외가 발생한다.")
    @Test
    void inputIsNotFormatted() {
        assertThatThrownBy(() -> Parser.numbers("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 검증 : 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputIsNotNumber() {
        assertThatThrownBy(() -> Parser.number("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액 입력 검증 : 숫자가 아니라면 예외가 발생한다.")
    @Test
    void moneyIsNotNumber() {
        assertThatThrownBy(() -> Parser.money("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액 입력 검증 : 1000의 배수가 아니라면 예외가 발생한다.")
    @Test
    void moneyIsNotValid() {
        assertThatThrownBy(() -> Parser.money("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}