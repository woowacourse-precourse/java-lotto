package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NoticeTest {
    @Test
    void 수익률_출력1() {
        String answer = "총 수익률은 62.5%입니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notice notice = new Notice();
        notice.profitRatio(62.499F);
        assertThat(out.toString()).isEqualTo(answer);
    }

    @Test
    void 수익률_출력2() {
        String answer = "총 수익률은 62.5%입니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notice notice = new Notice();
        notice.profitRatio(62.544F);
        assertThat(out.toString()).isEqualTo(answer);
    }

    @Test
    void 수익률_출력3() {
        String answer = "총 수익률은 100.0%입니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notice notice = new Notice();
        notice.profitRatio(100F);
        assertThat(out.toString()).isEqualTo(answer);
    }
}