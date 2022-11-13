package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_범위_테스트1() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

	@Test
    void 숫자_범위_테스트2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

	@Test
    void 숫자_범위_테스트3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 문자열_생성자_테스트1() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        lotto.printNumbers();
        assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 문자열_생성자_테스트2() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_생성자_테스트3() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_생성자_테스트4() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5.6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

	@Test
    void 숫자_포함_여부_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isEqualTo(true);
        assertThat(lotto.contains(6)).isEqualTo(true);
        assertThat(lotto.contains(7)).isEqualTo(false);
        assertThat(lotto.contains(40)).isEqualTo(false);
    }

    Integer getMatchCount(Lotto lotto, Lotto winning) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class app = Lotto.class;
        Class args[] = new Class[1];
        args[0] = Lotto.class;

        Object[] params = new Object[1];
        params[0] = winning;

        Method method = app.getDeclaredMethod("getMatchCount", args);
        method.setAccessible(true);
        return (Integer) method.invoke(lotto, params);
    }

    @Test
    void 맞은_숫자_수_테스트1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(getMatchCount(lotto, winning)).isEqualTo(3);
    }

    @Test
    void 맞은_숫자_수_테스트2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(10, 12, 13, 17, 18, 19));

        assertThat(getMatchCount(lotto, winning)).isEqualTo(0);
    }

    @Test
    void 등수_테스트1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.getResult(winning, 7)).isEqualTo(Prize.FIFTH);
    }

    @Test
    void 등수_테스트2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        assertThat(lotto.getResult(winning, 7)).isEqualTo(Prize.THIRD);
    }

    @Test
    void 등수_테스트3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        assertThat(lotto.getResult(winning, 6)).isEqualTo(Prize.SECOND);
    }

    @Test
    void 등수_테스트4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(10, 12, 13, 17, 18, 19));

        assertThat(lotto.getResult(winning, 6)).isEqualTo(Prize.NONE);
    }

    @Override
    public void runMain() { }
}
