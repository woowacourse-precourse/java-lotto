package lotto;

import lotto.Model.DataProcessing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DomainTest {
    @DisplayName("split한 string배열의 길이가 6인지 테스트")
    @Test
    void splitLottoTest() {
        String[] compare = { "1","2","3","4","5","6" };
        String testString = "1,2,3,4,5,6";
        DataProcessing dataProcessing = new DataProcessing();
        String[] result = dataProcessing.splitLottoNumber(testString);
        assertThat(result).isEqualTo(compare);
    }

    @DisplayName("총 수익률 소수점 한 자리 수 반올림 테스트")
    @Test
    void decimalPointTest() {
        float compare = 62.5f;
        DataProcessing dataProcessing = new DataProcessing();
        int[] resultWin = {1,0,0,0,0};
        float result = dataProcessing.totalReturn(8, resultWin);
        assertThat(result).isEqualTo(compare);
    }

    @DisplayName("총 금액 합산 테스트")
    @Test
    void totalWinPrize() {
        int compare = 31565000;
        DataProcessing dataProcessing = new DataProcessing();
        int[] resultWin = {3,1,1,1,0};
        int result = dataProcessing.totalMoney(resultWin);
        assertThat(result).isEqualTo(compare);
    }
}