package lotto;

import lotto.util.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


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

    @DisplayName("구매한 개수만큼 로또 생성.")
    @Test
    void createRandomLottos() {
        int generationNumber = 4;
        List<Lotto> testLotto = new LottoGenerator().generateLotto(generationNumber);
        assertThat(testLotto.size()).isEqualTo(generationNumber);
    }

    @DisplayName("입력한 값의 타입이 다르면 에러가 발생한다.")
    @Test
    void validateInputType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InputHandler inputHandler = new InputHandler();
        Method validateMethod = inputHandler.getClass().getDeclaredMethod("validateType", String.class);
        validateMethod.setAccessible(true);
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        assertThat(validateMethod.invoke(inputHandler, "1,2,3")).isEqualTo(actual);
    }







    // 아래에 추가 테스트 작성 가능
}
