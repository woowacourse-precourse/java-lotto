package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIOHandlerTest extends IOTest {
    private static LottoIOHandler lottoIOHandler;
    @BeforeAll
    static void initAll() {lottoIOHandler = new LottoIOHandler();}

    @Test
    @DisplayName("당첨 번호를 입력 검증")
    void getLottoAnswerTest(){
        systemIn("1,2,3,4,5,6");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoIOHandler.getLottoAnswer()).isEqualTo(list);
    }
}
