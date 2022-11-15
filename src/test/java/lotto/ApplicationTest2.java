package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest2 extends NsTest {
    Application app = new Application();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    public void inputTest1() {
        assertThat(app.userMoneyCheck("8000")).isEqualTo(8);
    }

    @Test
    public void inputTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
                    app.userMoneyCheck("1000j");
            }
        );
    }

    @Test
    public void winningNumberDuplicateTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,4,5,6,6");
                }
        );
    }

    @Test
    public void winningNumberNotNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,jj,5,6,6");
                }
        );
    }

    @Test
    public void winningNumberNotInRangeTest(){
        assertThrows(IllegalArgumentException.class, () -> {
                    new WinningNumbers("1,2,88,5,7,6");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
