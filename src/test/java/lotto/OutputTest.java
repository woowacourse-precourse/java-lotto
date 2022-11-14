package lotto;

import lotto.domain.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto
 * fileName : OutputTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class OutputTest {
    @DisplayName("outputLottoRank 실행 테스트")
    @Test
    void outPutTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.outputLottoRank(1, 1, 1, 1, 1);
        assertThat("3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n").isEqualTo(out.toString());
    }
}
