package lotto.domainTest;

import lotto.LottoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LottoControllerTest {
    LottoController controller = new LottoController();

    @Test
    void initLotto() {
        //given(준비)
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());

        //when(실행)
        System.setIn(in);
        controller.initLotto();

        //then(검증)
        Assertions.assertThat(controller.getLotto().getNumbers()).containsExactly(1,2,3,4,5,6);
    }

}
