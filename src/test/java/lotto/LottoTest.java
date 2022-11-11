package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
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

    @DisplayName("로또 번호를 입력하면 오름차순으로 정렬한다")
    @Test
    void sortLottoNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        List<Integer> lotto = List.of(34, 24, 40, 41, 10, 7);
        List<Integer> result = List.of(7, 10, 24, 34, 40, 41);

        Method method = lottoGame.getClass().getDeclaredMethod("getSortedByAscend", List.class);
        method.setAccessible(true);
        List<Integer> sortedLotto = (List<Integer>) method.invoke(lottoGame, lotto);

        assertThat(sortedLotto).isEqualTo(result);
    }

    @DisplayName("금액을 입력하면 로또 개수를 반환한다")
    @Test
    void getLottoCountByMoney() {
        LottoMachine lottoMachine = new LottoMachine();
        int money = 8000;
        int result = 8;

        int lottoCount = lottoMachine.getLottoCount(money);

        assertThat(lottoCount).isEqualTo(result);
    }

    @DisplayName("돈을 입력하면 금액만큼 로또를 생성한다")
    @Test
    void generateLottosByMoney() {
        LottoMachine lottoMachine = new LottoMachine();
        int money = 6000;
        int result = 6;

        List<Lotto> lottos = lottoMachine.generateLottos(money);

        assertThat(lottos.size()).isEqualTo(result);
    }

    @DisplayName("1과 45사이의 값이 아니면 예외가 발생한다")
    @Test
    void createNumberByOutOfRange() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateNumberRange", int.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, 46))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1과 45사이의 값이면 예외가 발생하지 않는다")
    @Test
    void createNumberByWithinRange() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateNumberRange", int.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, 44));
    }

    @DisplayName("값이 숫자가 아니면 예외가 발생한다")
    @Test
    void createNumberByNotIntegerType() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, "a1"))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 숫자면 예외가 발생하지 않는다")
    @Test
    void createNumberByIntegerType() throws NoSuchMethodException {
        LottoGame lottoGame = new LottoGame();

        Method method = lottoGame.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, "11"));
    }

    @DisplayName("5개의 콤마로 구분된 숫자들이 입력되면 6개의 숫자 리스트가 나온다")
    @Test
    void createSixNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        String winningNumbers = "1,7,10,24,37,45";
        List<Integer> result = List.of(1, 7, 10, 24, 37, 45);

        Method method = lottoGame.getClass().getDeclaredMethod("getNumbers", String.class);
        method.setAccessible(true);
        List<Integer> numbers = (List<Integer>) method.invoke(lottoGame, winningNumbers);

        assertThat(numbers).isEqualTo(result);
    }

    @DisplayName("1개의 보너스 번호가 6개의 당첨 번호 중에 포함되어있으면 예외가 발생한다")
    @Test
    void createBonusNumberIncludedInWinningNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumber = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 7;

        Method method = lottoGame.getClass().getDeclaredMethod("validateContainsInWinningNumber", List.class, int.class);
        method.setAccessible(true);

        assertThatThrownBy(() -> method.invoke(lottoGame, winningNumber, bonusNumber))
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개의 보너스 번호가 6개의 당첨 번호 중에 포함되어있지 않으면 예외가 발생하지 않는다")
    @Test
    void createBonusNumberExcluded() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumber = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 11;

        Method method = lottoGame.getClass().getDeclaredMethod("validateContainsInWinningNumber", List.class, int.class);
        method.setAccessible(true);

        assertThatNoException()
                .isThrownBy(() -> method.invoke(lottoGame, winningNumber, bonusNumber));
    }

    @DisplayName("뽑기 기계에 당첨 번호를 넣으면 당첨 번호가 들어간다")
    @Test
    void generateWinningNumberInDrawingMachine() throws NoSuchFieldException, IllegalAccessException {
        List<Integer> result = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 11;
        DrawingMachine drawingMachine = new DrawingMachine(result, bonusNumber);

        Field field = drawingMachine.getClass().getDeclaredField("winningNumbers");
        field.setAccessible(true);
        List<Integer> winningNumber = (List<Integer>) field.get(drawingMachine);

        assertThat(winningNumber).isEqualTo(result);
    }

    @DisplayName("뽑기 기계에 보너스 번호를 넣으면 보너스 번호가 들어간다")
    @Test
    void generateBonusNumberInDrawingMachine() throws NoSuchFieldException, IllegalAccessException {
        List<Integer> winningNumber = List.of(1, 7, 10, 24, 37, 45);
        int result = 11;
        DrawingMachine drawingMachine = new DrawingMachine(winningNumber, result);

        Field field = drawingMachine.getClass().getDeclaredField("bonusNumber");
        field.setAccessible(true);
        int bonusNumber = (int) field.get(drawingMachine);

        assertThat(bonusNumber).isEqualTo(result);
    }
}
