package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("숫자가 아닌 다른 글자가 들어가면 예외가 발생한다")
    @Test
    void createMoneyByNotNumber() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateMoneyType", String.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, "a1000"))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 들어가면 예외가 발생하지 않는다")
    @Test
    void createMoneyByNumber() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateMoneyType", String.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, "1000"));
    }

    @DisplayName("숫자 예외가 발생 시 메시지에 접두어로 [ERROR]가 들어간다")
    @Test
    void errorMessageByNotNumber() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateMoneyType", String.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, "a1000"))
                .getCause()
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1000원 단위가 아닌 돈이 입력됐을 때 예외가 발생한다")
    @Test
    void createMoneyByNotUnitOf1000() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateUnitOf1000", String.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, "1200"))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위인 돈이 입력됐을 때 예외가 발생하지 않는다")
    @Test
    void createMoneyByUnitOf1000() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateUnitOf1000", String.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, "2000"));
    }

    @DisplayName("로또 번호를 생성하면 리스트로 로또 번호가 나온다")
    @Test
    void generateLottoNumberByList() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoMachine lottoMachine = new LottoMachine();

        Method method = lottoMachine.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        Object lottoNumber = method.invoke(lottoMachine);

        assertThat(lottoNumber).isInstanceOf(List.class);
    }

    @DisplayName("로또 번호를 생성하면 6개의 번호가 나온다")
    @Test
    void generateLottoNumberBySixLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoMachine lottoMachine = new LottoMachine();
        int result = 6;

        Method method = lottoMachine.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        List<Integer> lottoNumber = (List<Integer>) method.invoke(lottoMachine);

        assertThat(lottoNumber.size()).isEqualTo(result);
    }

    @DisplayName("로또 번호를 생성하면 중복없이 6개의 번호가 나온다")
    @Test
    void generateLottoNumberByNotDuplicated() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoMachine lottoMachine = new LottoMachine();
        int result = 6;

        Method method = lottoMachine.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        List<Integer> lottoNumber = (List<Integer>) method.invoke(lottoMachine);
        int lottoNumberSize = new HashSet<>(lottoNumber).size();

        assertThat(lottoNumberSize).isEqualTo(result);
    }
}
