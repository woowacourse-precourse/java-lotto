package lotto;

import game.Calculate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.BuyLotto;
import user.UserInput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호의 개수는 6개가 넘으면 안됩니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("발행한 로또번호는 45가 넘으면 안된다.")
    @Test
    void checkLottoNumberOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}

class UserInputTest {
    @DisplayName("유저가 입력한 값 Sting -> Integer 형변환 테스트")
    @Test
    void cast() {
        UserInput userInput = new UserInput();
        String str = "1,2,3,4,5,6";

        Assertions.assertThat(userInput.userLotto(str)).isEqualTo(List.of(1,2,3,4,5,6));
    }


    @DisplayName("금액에 맞게 로또를 발행해야 한다.")
    @Test
    void countLotto1 (){
        int input = 3000;
        BuyLotto buyLotto = new BuyLotto();
        int num = buyLotto.countHowMany(input);

        Assertions.assertThat(num).isEqualTo(3);
    }

    @DisplayName("1000원 단위로 나누어 떨어지지 않으면 예외로 처리한다.")
    @Test
    void countLotto2 (){
        int input = 3100;
        BuyLotto buyLotto = new BuyLotto();
        assertThatThrownBy(() -> buyLotto.countHowMany(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("값을 잘못 입력하면 IllegalArgumentException를 발생시킨다.")
    @Test
    void countLotto3 (){
        int input = -1000;
        BuyLotto buyLotto = new BuyLotto();
        assertThatThrownBy(() -> buyLotto.countHowMany(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 잘못 입력하였습니다.");
    }

    @DisplayName("값을 잘못 입력하면 IllegalArgumentException를 발생시킨다.")
    @Test
    void countLotto4 (){
        int input = 0;
        BuyLotto buyLotto = new BuyLotto();
        assertThatThrownBy(() -> buyLotto.countHowMany(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 잘못 입력하였습니다.");
    }
}

class Prize {
    Calculate calculateGrade = new Calculate();
    @DisplayName("1등 등수를 출력한다.")
    @Test
    void grade1() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        List<Integer> input = List.of(1,2,3,4,5,6);
        int bonus = 7;

        Assertions.assertThat(calculateGrade.grade(lotto, input, bonus)).isEqualTo(2_000_000_000);
    }

    @DisplayName("2등 등수를 출력한다.")
    @Test
    void grade2() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        List<Integer> input = List.of(1,2,3,4,5,7);
        int bonus = 6;

        Assertions.assertThat(calculateGrade.grade(lotto, input, bonus)).isEqualTo(30_000_000);
    }

    @DisplayName("3등 등수를 출력한다.")
    @Test
    void grade3() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        List<Integer> input = List.of(1,2,3,4,5,8);
        int bonus = 7;

        Assertions.assertThat(calculateGrade.grade(lotto, input, bonus)).isEqualTo(1_500_000);
    }

    @DisplayName("4등 등수를 출력한다.")
    @Test
    void grade4() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        List<Integer> input = List.of(1,2,3,4,7,8);
        int bonus = 7;

        Assertions.assertThat(calculateGrade.grade(lotto, input, bonus)).isEqualTo(50_000);
    }

    @DisplayName("5등 등수를 출력한다.")
    @Test
    void grade5() {
        List<Integer> lotto = List.of(1,2,3,4,5,6);
        List<Integer> input = List.of(1,2,3,10,11,12);
        int bonus = 7;

        Assertions.assertThat(calculateGrade.grade(lotto, input, bonus)).isEqualTo(5_000);
    }
}
