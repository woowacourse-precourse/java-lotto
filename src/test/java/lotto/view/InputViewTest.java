package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Nested
    class inputTest {
        //@ParameterizedTest
        @ValueSource(strings = "1,2,3,4,5,6\n")
        void 당첨_번호_입력_테스트(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            String winningNum = "1,2,3,4,5,6";
            String result = InputView.inputWinningNum();
            assertThat(result).isEqualTo(winningNum);
        }

        //@ParameterizedTest
        @ValueSource(strings = {"1000\n"})
        void 로또_구입_금액_입력(String input) {
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            String price = "1000";
            String result = InputView.buyLotto();
            assertThat(result).isEqualTo(price);

        }
    }





}