package lotto.domainTest;

import lotto.LottoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoControllerTest {
    LottoController controller = new LottoController();

    @Test
    @DisplayName("입력한 당첨번호가 숫자가 아닌경우")
    void lottoNumericTest() {
        //given(준비)
        String input = "1,2,3,4,A,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)

        //then(검증)
        try {
            System.setIn(in);
            controller.initLotto();
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).contains("[ERROR]");
        }
    }
}
