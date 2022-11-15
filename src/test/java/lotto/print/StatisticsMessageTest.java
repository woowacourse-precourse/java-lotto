package lotto.print;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsMessageTest {
    @Test
    void sendMessageTest() {
        assertThat(StatisticsMessage.sendMessage("1등")).isEqualTo("6개 일치 (2,000,000,000원) - ");
        assertThat(StatisticsMessage.sendMessage("guide")).isEqualTo("당첨 통계" + System.lineSeparator() + "---");
    }// sendMessageTest
}//end class
