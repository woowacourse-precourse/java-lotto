package lotto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Disabled
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 빈 값을 입력한 경우 예외 발생")
    @Test
    void checkInputIsNotEmpty() {
        assertThatThrownBy(() -> new Lotto(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 띄어쓰기만 입력한 경우 예외 발생")
    @Test
    void checkInputIsSpace() {
        assertThatThrownBy(() -> new Lotto("    "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 문자열 리스트에 숫자와 문자가 모두 있는 경우 예외 발생")
    @Test
    void checkListDigitWithString() {
        assertThatThrownBy(() -> new Lotto("1,2,3,a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 쉼표 구분의 값이 6개를 넘은 경우 예외 발생")
    @Test
    void check7Numbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 쉼표 구분의 값이 6개가 되지 않는 경우 예외 발생")
    @Test
    void check5Numbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 45를 초과하는 값이 있는 경우 예외 발생")
    @Test
    void checkOutOfRangeNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,54"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 1 미만의 값이 있는 경우 예외 발생")
    @Test
    void checkOutOfRangeNumbers2() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 문자열을 문자열 리스트로 형 변환")
    @Test
    void convertStringToListTest() throws NoSuchMethodException {
        String inputNumbers = "1,2,3,4,5,6";
        List<String> expectedNumbers = List.of("1", "2", "3", "4", "5", "6");
        Lotto lotto = new Lotto(inputNumbers);
        Method method = lotto.getClass().getDeclaredMethod("convertStringToList", String.class);
        method.setAccessible(true);

        try {
            List<String> result = (List<String>) method.invoke(lotto, inputNumbers);
            assertThat(result).isEqualTo(expectedNumbers);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
