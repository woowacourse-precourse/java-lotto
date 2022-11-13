package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    // 아래에 추가 테스트 작성 가능
    Computer computer = new Computer();
    User user = new User();
    @Test
    void 로또_구입_출력() {
        int amount = user.moneyToAmount(8000);
        user.setLottoList(computer.issuedLotto(amount));
    }

    @Test
    void 당첨_번호() {
        int[] numberArray = computer.splitNumber("1,2,3,4,5,6");
        Assertions.assertThat(numberArray).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void 당청번호_숫자_o() {
        computer.isNum(new String[]{"1", "2", "3", "4", "5"});
    }

    @Test
    void 당첨번호_숫자_x() {
        assertThatThrownBy(() -> computer.isNum(new String[]{"1", "2", "3", "4", "5", "k"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_x() {
        assertThatThrownBy(() -> computer.isCorrectRange(new String[]{"1", "2", "3", "4", "5", "45", "46"}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> computer.isCorrectRange(new String[]{"0", "2", "3", "4", "5", "45"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_범위_o() {
        int[] intArray = computer.isCorrectRange(new String[]{"1","45", "2", "3"});
    }

    @Test
    void 당첨번호_길이_o() {
        computer.isCorrectSize(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void 당첨번호_길이_x() {
        assertThatThrownBy(() -> computer.isCorrectSize(new int[]{1, 2, 3, 4, 5, 6, 7}))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
