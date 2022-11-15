package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest extends NsTest {
    private static final String WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호가 올바르게 입력되지 않았습니다.";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 볼 번호가 올바르게 입력되지 않았습니다.";

    @DisplayName("당첨 번호를 4개만 입력한 경우")
    @Test
    void 당첨번호가_적은_경우() {
        runException("1000", "1,2,3,4");
        assertThat(output()).contains(WINNING_NUMBERS_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호를 8개 입력한 경우")
    @Test
    void 당첨번호가_많은_경우() {
        runException("1000", "1,2,3,4,5,6,7,8");
        assertThat(output()).contains(WINNING_NUMBERS_ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호의 범위가 올바르지 않은 경우")
    @Test
    void 당첨번호_범위_테스트() {
        runException("1000", "100,2,3,4,5,6");
        assertThat(output()).contains(WINNING_NUMBERS_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호의 범위가 올바르지 않은 경우")
    @Test
    void 보너스번호_범위_테스트() {
        runException("1000", "1,2,3,4,5,6", "52");
        assertThat(output()).contains(BONUS_NUMBER_ERROR_MESSAGE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}