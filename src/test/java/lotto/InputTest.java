package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Executable;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static lotto.Input.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {

    @Test
    void 유저_로또_구매_성공(){
        runTest(() -> {
            Input.buyLotto();
        }, "10000");
    }

    @Test
    void 유저_로또_구매_실패(){
        runTest(() -> {
            assertThatThrownBy(() -> Input.buyLotto())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1000j");

        runTest(() -> {
            assertThatThrownBy(() -> Input.buyLotto())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1000J");

        runTest(() -> {
            assertThatThrownBy(() -> Input.buyLotto())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1100");
    }

    @Test
    void 유저_당첨_번호_입력_성공(){
        runTest(() -> {
            Input.userInputLottoNumber();
        }, "1,2,3,4,5,6");
    }

    @Test
    void 유저_당첨_번호_입력_실패(){
        runTest(() -> {
            assertThatThrownBy(() -> Input.userInputLottoNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1,2,3,3,4,5");

        runTest(() -> {
            assertThatThrownBy(() -> Input.userInputLottoNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1,2,3,4,5,6,7");
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
