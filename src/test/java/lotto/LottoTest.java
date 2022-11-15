package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    Game game = new Game();
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("사용자가 입력한 값 형변환 테스트")
    @Test
    void userCast() {
        User user = new User();
        Assertions.assertThat(user.userLotto("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("금액에 맞게 로또를 발행해야 한다.")
    @Test
    void buyLottoTest1 (){
        int money = 5000;
        int number = Lotto.count(money);
        Assertions.assertThat(number).isEqualTo(5);
    }

    @DisplayName("1000원 단위가 아니면 예외로 처리해야 한다.")
    @Test
    void buyLottoTest2 (){
        int money = 5500;
        assertThatThrownBy(() -> Lotto.count(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위로 입력해야 합니다.");
    }
    @DisplayName("금액을 잘못 입력하면 예외를 발생시켜야 한다.")
    @Test
    void buyLottoTest3 (){
        int money = -5000;
        assertThatThrownBy(() -> Lotto.count(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 값을 잘못 입력하였습니다.");
    }

    @DisplayName("1등을 출력한다.")
    @Test
    void printGrade1thTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        Assertions.assertThat(game.getGrade(lotto, user, bonus)).isEqualTo(1);
    }

    @DisplayName("2등을 출력한다.")
    @Test
    void printGrade2ndTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> user = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 6;
        Assertions.assertThat(game.getGrade(lotto, user, bonus)).isEqualTo(2);
    }

    @DisplayName("3등을 출력한다.")
    @Test
    void printGrade3rdTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> user = List.of(1, 2, 3, 4, 5, 8);
        int bonus = 7;
        Assertions.assertThat(game.getGrade(lotto, user, bonus)).isEqualTo(3);
    }

    @DisplayName("4등을 출력한다.")
    @Test
    void printGrade4thTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> user = List.of(1, 2, 3, 4, 8, 9);
        int bonus = 10;
        Assertions.assertThat(game.getGrade(lotto, user, bonus)).isEqualTo(4);
    }

    @DisplayName("5등을 출력한다.")
    @Test
    void printGrade5thTest() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> user = List.of(1, 2, 3, 7, 8, 9);
        int bonus = 7;
        Assertions.assertThat(game.getGrade(lotto, user, bonus)).isEqualTo(5);
    }

    @Test
    void resultTest1() {
        List<List<Integer>> lottoList = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Integer> result = List.of(0, 2, 1, 0, 0, 0);

        Assertions.assertThat(game.correctLottoCount(lottoList, user, bonus)).isEqualTo(result);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfit() {
        List<Integer> result = List.of(0, 0, 0, 0, 0, 1);
        Assertions.assertThat(game.getRate(result, 6000)).isEqualTo("83.3%");
    }
}
