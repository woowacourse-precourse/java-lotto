package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() { }
}
