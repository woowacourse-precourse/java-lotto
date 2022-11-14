package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
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

    @Test
    void 당첨_내역_출력1() {
        String answer = ("당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개"
                + "\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n")
                .replaceAll("\\n", System.getProperty("line.separator"));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Notice notice = new Notice();
        HashMap<String, Integer> winningCount = new HashMap<>();
        winningCount.put("FIFTH", 0);
        winningCount.put("FOURTH", 0);
        winningCount.put("THIRD", 0);
        winningCount.put("SECOND", 0);
        winningCount.put("FIRST", 1);
        notice.winningAnalysis(winningCount);
        assertThat(out.toString()).isEqualTo(answer);
    }
}