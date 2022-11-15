package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest2 extends NsTest {
    Application app = new Application();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    public void inputTest1() {
        assertThat(app.userInput("8000")).isEqualTo(8);
    }

    @Test
    public void inputTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
                    app.userInput("1000j");
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
