package lotto.controller.converter;

import lotto.domain.info.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasicResultMessageTest {
    BasicResultMessage resultMessage = new BasicResultMessage();

    @DisplayName("각 등수에 대한 결과가 출력된다. - 1")
    @Test
    void createRankMessage() {
        List<Rank> rankList = List.of(Rank.FIFTH, Rank.THIRD, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR);

        String rankMessage = resultMessage.createRankMessage(rankList);

        System.out.println(rankMessage);
        assertThat(rankMessage).contains("3개 일치 (5,000원) - 1개");
        assertThat(rankMessage).contains("5개 일치, 보너스 볼 일치  (30,000,000원) - 0개");
    }

    @DisplayName("각 등수에 대한 결과가 출력된다. - 2")
    @Test
    void createRankMessage2() {
        List<Rank> rankList = List.of(Rank.FIFTH, Rank.THIRD, Rank.FIRST, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR);

        String rankMessage = resultMessage.createRankMessage(rankList);

        System.out.println(rankMessage);
        assertThat(rankMessage).contains("6개 일치 (2,000,000,000원) - 1개 ");
        assertThat(rankMessage).contains("5개 일치, 보너스 볼 일치  (30,000,000원) - 0개");
    }

    @DisplayName("수익률이 반환된다. - 1")
    @Test
    void rate1() {
        List<Rank> rankList = List.of(Rank.FIFTH, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR);

        String rateMessage = resultMessage.createRateMessage(rankList, 8000);

        System.out.println(rateMessage);
        assertThat(rateMessage).isEqualTo("총 수익률은 62.5%입니다.");
    }

    @DisplayName("수익률이 반환된다. - 2")
    @Test
    void rate2() {
        List<Rank> rankList = List.of(Rank.FIRST, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR);

        String rateMessage = resultMessage.createRateMessage(rankList, 5000);

        System.out.println(rateMessage);
        assertThat(rateMessage).isEqualTo("총 수익률은 40,000,000.0%입니다.");
    }

    @DisplayName("수익률이 반환된다. - 3")
    @Test
    void rate3() {
        List<Rank> rankList = List.of(Rank.FIFTH, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR, Rank.EXTERIOR);

        String rateMessage = resultMessage.createRateMessage(rankList, 5000);

        System.out.println(rateMessage);
        assertThat(rateMessage).isEqualTo("총 수익률은 100.0%입니다.");
    }
}