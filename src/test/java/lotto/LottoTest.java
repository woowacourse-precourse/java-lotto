package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 번호가 1~45 밖으로 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 999)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonus 번호가 1~45 밖으로 넘어가면 예외 발생.")
    @Test
    void createBonusByOverRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonus(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스");
    }

    @DisplayName("bonus 번호가 당첨번호와 중복일 시 예외 발생.")
    @Test
    void createBonusByDuplicationWithWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonus(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스");
    }

    @DisplayName("로또 발생하는거 체크")
    @Test
    void test_LottoMachine_make_lotto_numbers() {
        List<Integer> numbers = LottoMachine.generateLotto();
        System.out.println(numbers);
    }

    @DisplayName("LottoCheck 의 전체적인 test")
    @Test
    void test_Lotto_game_test() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setBonus(7);
        List<Integer> numbers = LottoMachine.generateLotto();
        System.out.println("winning numbers: " + lotto.getWinningNumbers());
        System.out.println("bonus number: " + lotto.getBonus());
        System.out.println("random numbers: " + numbers);

        int countMatchedNumber = LottoCheck.checkNumsOfMatchedNumber(lotto.getWinningNumbers(), numbers);
        boolean containBonus = LottoCheck.containBonus(lotto.getBonus(), numbers);
        System.out.println("count: " + countMatchedNumber);
        System.out.println("containBonus: " + containBonus);
    }

    @DisplayName("금액이 1000으로 나누어 떨어지지 않을 때")
    @Test
    void test_MyLotto_Money_is_1001() {
        assertThatThrownBy(() -> new MyLotto(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액만큼 Lotto 구매 했는지")
    @Test
    void test_MyLotto_BuyLotto_Size_Money_15000(){
        int money = 15000;
        MyLotto myLotto = new MyLotto(money);
        assertThat(myLotto.getMyPocket().size()).isEqualTo(15);
    }
}
