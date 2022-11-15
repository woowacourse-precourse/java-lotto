package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Lotto;
import domain.LottoGrade;
import view.InputView;
import view.LottoGameInputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import dto.ScratchResult;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoGameInputViewTest extends NsTest {

    private static InputView lottoGameView;

    @BeforeAll
    private static void initialize() {
        lottoGameView = LottoGameInputView.getInstance();
    }

    @Override
    protected void runMain() {

    }

    @Nested
    @DisplayName("getNumbersFromUser 메서드는")
    class describe_getNumbersFromUser {


        @Nested
        @DisplayName("사용자로부터 당첨 숫자 목록을 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 리스트로 반환한다")
            void return_numberList_when_receive_right_input() {
                run("1,2,3,4,5");
                assertThat(lottoGameView.getWinningNumbersFromUser().equals(List.of(1, 2, 3, 4, 5)));

                run("1");
                assertThat(lottoGameView.getWinningNumbersFromUser().equals(List.of(1)));
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    run(",12");
                    lottoGameView.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("");
                    lottoGameView.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("3,2,");
                    lottoGameView.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,2,a,");
                    lottoGameView.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,,2");
                    lottoGameView.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("getBonusNumberFromUser 메서드는")
    class describe_getBonusNumberFromUser {

        @Nested
        @DisplayName("사용자로부터 숫자를 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 Integer 형태로 반환한다.")
            void return_number_when_receive_right_input() {
                run("1");
                assertThat(lottoGameView.getBonusNumberFromUser()).isEqualTo(1);

                run("52");
                assertThat(lottoGameView.getBonusNumberFromUser()).isEqualTo(52);
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    run(",");
                    lottoGameView.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("abc");
                    lottoGameView.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("");
                    lottoGameView.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("a");
                    lottoGameView.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,,2");
                    lottoGameView.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
