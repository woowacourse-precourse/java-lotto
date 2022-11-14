package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("구매 금액에 문자가 들어간 경우 예외가 발생한다.")
    @Test
    void errorMessageTestInputPurchaseAmountIncludeCharacter() {
        assertSimpleTest(() -> {
            run("1000a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void errorMessageTestInputPurchaseAmountIsNotMultipleOf1000() {
        assertSimpleTest(() -> {
            run("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 1과 45사이에 없는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersAreNotBetween1And45() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 중복인 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersAreDuplicate() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void errorMessageTestNumbersCountIsNot6() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호는 당첨 번호에 있는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusInWinNumbers() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 1과 45사이에 없는 경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusIsNotBetween1And45() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 문자가 있는경우 예외가 발생한다.")
    @Test
    void errorMessageTestBonusIncludeCharacter() {
        assertSimpleTest(() -> {
            run("8000","1,2,3,4,5,6","0a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
