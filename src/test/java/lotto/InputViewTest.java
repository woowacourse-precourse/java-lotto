package lotto;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    String error = "[ERROR]";
    String purchase = "개를";
    OutputStream out;
    @BeforeEach
    void 스트림_생성() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 입력_예외() {
        String str = "1001";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.inputMoney();
        assertThat(out.toString()).contains(error)
                .doesNotContain(purchase);
    }
}
