package lotto.DataTable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTableTest {
    @DisplayName("Score Table 초기 세팅 값 확인")
    @Test
    void testInitialScoreTable() {
        Map<Integer, Integer> scoreMap = PrizeTable.setScoreTable();
        Map<Integer, Integer> EXPECTED_RESULT = Map.of(2, 0, 3, 0, 4, 0, 5, 0, 6, 0);
        assertThat(scoreMap).isEqualTo(EXPECTED_RESULT);
    }


    @DisplayName("맞춘 개수 만큼 상금 액수 반환")
    @Test
    void test() {
        int count = 6;
        int price = PrizeTable.valueOfPrize(count);
        int EXPECTED_RESULT = 2000000000;
        assertThat(price).isEqualTo(EXPECTED_RESULT);
    }
}
