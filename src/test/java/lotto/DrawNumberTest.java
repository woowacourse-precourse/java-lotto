package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DrawNumberTest {
    @Test
    void 추첨_번호_생성_확인_테스트() {
        int ticketAmount = 5;
        DrawNumber drawNumber = new DrawNumber(ticketAmount);
        int resultLength = 5;
        assertThat(drawNumber.lottos.size()).isEqualTo(resultLength);
    }

}