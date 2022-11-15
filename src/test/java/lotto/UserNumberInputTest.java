package lotto;

import lotto.domain.Computer;
import lotto.domain.Game;
import lotto.domain.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import lotto.exception.InvalidUserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserNumberInputTest {

    @DisplayName("사용자가 1000원 단위로 로또 구입 금액을 입력하지 않으면 오류가 발생한다")
    @Test
    void userInputTest() {
       User user = new User();
       String input = "1500";

       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);

       assertThatThrownBy(() -> user.enterLottoBuyAmount())
               .isInstanceOf(IllegalArgumentException.class)
               .hasMessageContaining("1000원 단위로 입력하셔야 합니다.");
    }

    @DisplayName("6개의 숫자를 반점으로 구분해 입력하지 않으면 오류가 발생한다.")
    @Test
    void userLottoNumberInputTest() {

        /** 올바르지 않은 입력에 대한 측정 **/

        Game game = createGame();
        String input = "1 2 3 4 5 6";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> game.enterWinningNumber())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining("올바른 형식으로 입력해 주세요.");

        /** 올바른 입력에 대한 측정 **/

        input = "1,2,3,4,5,6";

        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.enterWinningNumber();
    }

    @DisplayName("보너스 번호 입력 시, 1~45 범위의 숫자 데이터를 입력하지 않으면 오류가 발생한다")
    @Test
    void userBonusNumberValidRangeInputTest() {
        Game game = createGame();
        String input = "46";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> game.enterBonusNumber())
                .isInstanceOf(InvalidUserInputException.class)
                .hasMessageContaining("1 ~ 45 사이의 숫자를 입력해 주세요.");
    }

    @DisplayName("보너스 번호 입력 시, 당첨 번호와 중복되는 숫자를 입력하면 오류가 발생한다")
    @Test
    void userBonusNumberDuplicateWinningNumbersInputTest() {
        Game game = createGame();
        String input = "1,2,3,4,5,6";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.enterWinningNumber();

        input = "5";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> game.enterBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호와 다른 보너스 번호를 입력해 주세요.");
    }

    public Game createGame() {
        User user = new User();
        Computer computer = new Computer();

        return new Game(user, computer);
    }
}
