package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.ui.OutputMessageGenerator.*;

public class OutputMessageGeneratorTest {
    @DisplayName("`[구매 수량]개를 구매했습니다.` 를 반환한다.")
    @Test
    void getPurchaseLottoMessageTest() {
        assertThat(getPurchaseLottoMessage(4))
                .isEqualTo("4개를 구매했습니다.");
    }

    @DisplayName("오름차순으로 정렬한 로또 번호를 문자열로 반환한다.")
    @Test
    void getAllLottoNumbersByAscendingOrderTest() {
        Lotto lotto = new Lotto(List.of(1, 4, 5, 6, 2, 3));
        assertThat(getLottoNumbersByAscendingOrder(lotto))
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("각 당첨 순위의 결과를 문자열 리스트로 반환한다.")
    @Test
    void getTotalRankCountMessageTest() {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 2,
                Rank.THIRD, 3,
                Rank.FOURTH, 4,
                Rank.FIFTH, 5,
                Rank.NO_LUCK, 6
        ));

        List<String> expected = List.of(
                "3개 일치 (5,000원) - 5개",
                "4개 일치 (50,000원) - 4개",
                "5개 일치 (1,500,000원) - 3개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                "6개 일치 (2,000,000,000원) - 1개"
        );

        assertThat(getTotalRankCountMessage(rankCounts))
                .isEqualTo(expected);
    }

    @DisplayName("`총 수익률은 [수익률]%입니다.`를 반환한다")
    @Test
    void getYieldMessageTest() {
        assertThat(getYieldMessage("32.5"))
                .isEqualTo("총 수익률은 32.5%입니다.");
    }
}
