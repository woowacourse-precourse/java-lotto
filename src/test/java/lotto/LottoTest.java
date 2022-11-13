package lotto;

import lotto.Domain.Lotto;
import lotto.Utils.LottoInspector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static lotto.Enum.ErrorMessage.*;
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
    @DisplayName("당첨번호를 입력할때 예외를 확인한다.")
    @Test
    void inputWinningNumbers () {
        LottoInspector inspector = new LottoInspector();

        String input01 ="1,2,3,4,5,5";
        assertThatThrownBy(() -> inspector.winningNumberToList(input01))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBERS.toMessage());

        String input02 ="1,2,3,4,5,6,7";
        assertThatThrownBy(() -> inspector.winningNumberToList(input02))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_WINNING_NUMBER_LENGTH.toMessage());

        String input03 ="1,2,3,4,5";
        assertThatThrownBy(() -> inspector.winningNumberToList(input03))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_PROPER_WINNING_NUMBER_LENGTH.toMessage());

        String input04 ="1,2,삼,4,5,6";
        assertThatThrownBy(() -> inspector.winningNumberToList(input03))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INPUT_INTEGER_MONEY_VALUE.toMessage());


    }

    public static InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
