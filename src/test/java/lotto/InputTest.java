package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Executable;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Input.*;
import static org.assertj.core.api.Assertions.*;

public class InputTest extends NsTest {


    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 유저_로또_구매_실패_buyLotto(){
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_구매개수_세기_성공_checkHowManyLotto(){
        int userInput = 1000;
        init();
        int funcResult = Input.checkHowManyLotto(userInput);

        assertThat(funcResult).isEqualTo(1);
    }


    @Test
    void 로또_구매개수_세기_실패_checkHowManyLotto(){
        int userInput = 1100;
        init();
        assertSimpleTest(() -> {
            runException(String.valueOf(userInput));
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private void runTest(final Executable executable, final String... args){
        command(args);
        assertSimpleTest((org.junit.jupiter.api.function.Executable) executable);
    }

    private void command(final String... args){
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
