package lotto.situation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        illegalArgumentExceptionOccurrenceCheck(List.of(1, 2, 3, 4, 5, 6, 7));
    }
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        illegalArgumentExceptionOccurrenceCheck(List.of(1, 2, 3, 4, 5));
        illegalArgumentExceptionOccurrenceCheck(List.of());
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        illegalArgumentExceptionOccurrenceCheck(List.of(1, 2, 3, 4, 5, 5));
    }

    @DisplayName("로또 번호에 1~45이외의 번호가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBound() {
        illegalArgumentExceptionOccurrenceCheck(List.of(1, 2, 3, 4, 5, 46));
        illegalArgumentExceptionOccurrenceCheck(List.of(0, 2, 3, 4, 5, 6));
    }
    void illegalArgumentExceptionOccurrenceCheck(List<Integer> errorCase) {
        assertThatThrownBy(() -> new Lotto(errorCase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 메세지가 출력한다.")
    @Test
    void createLottoByOverSizeForPrint() {
        errorMessageCheck(List.of(1, 2, 3, 4, 5, 6, 7), "[ERROR] 로또 번호는 6개입니다.");
    }
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSizeForPrint() {
        errorMessageCheck(List.of(1, 2, 3, 4, 5), "[ERROR] 로또 번호는 6개입니다.");
        errorMessageCheck(List.of(), "[ERROR] 로또 번호는 6개입니다.");
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 메세지를 출력한다.")
    @Test
    void createLottoByDuplicatedNumberForPrint() {
        errorMessageCheck(List.of(1, 2, 3, 4, 5, 5), "[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
    @DisplayName("로또 번호에 1~45이외의 번호가 있으면 예외 메세지를 출력한다.")
    @Test
    void createLottoByOutOfBoundForPrint() {
        errorMessageCheck(List.of(1, 2, 3, 4, 5, 46), "[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        errorMessageCheck(List.of(0, 2, 3, 4, 5, 45), "[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }
    void errorMessageCheck(List<Integer> errorCase, String expectMessage) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        illegalArgumentExceptionOccurrenceCheck(errorCase);
        assertThat(out.toString()).isEqualTo(expectMessage);
    }

    @DisplayName("입력받은 로또 번호가 변하지 않고 반환된다.")
    @Test
    void unChangingReturn() {
        List<Integer> input = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(input);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
    @DisplayName("입력받은 로또 번호가 생성자에 사용된 입력 객체를 변경하더라도 변하지 않고 반환된다.")
    @Test
    void unChangingReturnAfterInputChanged() {
        List<Integer> input = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(input);
        input.add(7);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
    @DisplayName("입력받은 로또 번호가 getNumbers()로 반환된 객체를 변경하더라도 변하지않고 반환된다.")
    @Test
    void unChangingReturnAfterGetInstanceChanged() {
        List<Integer> input = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(input);
        lotto.getNumbers().add(8);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
