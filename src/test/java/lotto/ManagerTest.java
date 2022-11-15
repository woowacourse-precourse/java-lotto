package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final Manager manager = new Manager();

    @DisplayName("당첨 번호 정상 입력")
    @Test
    void setWinTest() {
        run("1,2,3,4,5,6");
        manager.setWin();
        assertThat(manager.getWin()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("예외: 당첨 번호 6개가 아닌 경우")
    @Test
    void isValidWinCount() {
        run("1,2");
        manager.setWin();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("예외: 당첨 번호 구분자가 다른 경우")
    @Test
    void isValidWinSplit() {
        run("1.2.3.4.5.6");
        manager.setWin();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("예외: 당첨 번호에 중복값이 있는 경우")
    @Test
    void hasDuplicatedWin() {
        run("1,2,3,3,4,5");
        manager.setWin();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Override
    public void runMain() {
        return;
    }
}
