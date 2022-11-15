package lotto.buyLotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤으로 생성한 로또 번호와 당첨 번호 일치 갯수 확인")
    @Test
    void compareNumbersTest() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        int [] prize = {1,2,3,4,5,6};

        Lotto lotto = new Lotto(nums);
        int n = lotto.compareNumbers(prize);
        Assertions.assertThat(n).isEqualTo(6);
    }

    @DisplayName("랜덤으로 생성한 로또 번호와 보너스 번호 일치 여부 확인")
    @Test
    void compareNumbersWithBonusNumberTest() {
        List<Integer> random = List.of(1,2,3,4,5,6);
        int [] prize = {1,2,3,4,5,7};
        int bonusNumber = 6;

        Lotto lotto = new Lotto(random);
        int n = lotto.compareNumberWithBonus(prize, bonusNumber);
        Assertions.assertThat(n).isEqualTo(6);
    }

    @DisplayName("랜덤으로 생성한 로또 번호와 보너스 번호 일치 여부 확인 - 보너스 제외 6개 맞을 경우")
    @Test
    void compareNumbersWithBonusNumberFailTest() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        int [] prize = {1,2,3,4,5,6};
        int bonusNumber = 7;

        Lotto lotto = new Lotto(numbers);
        int n = lotto.compareNumberWithBonus(prize, bonusNumber);
        Assertions.assertThat(n).isEqualTo(0);
    }


}
