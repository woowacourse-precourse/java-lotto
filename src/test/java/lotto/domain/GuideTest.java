package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Guide.printRateOfReturn;

class GuideTest {
    @DisplayName("로또 통계 메시지 출력")
    @Test
    void printLottoStatisticsMessage() {
        List<Integer> lottoResult = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5));
        Guide.printLottoStatistics(Guide.createLottoStatisticsMessage(lottoResult));
    }

    @DisplayName("수익률 반올림하여 소수점 n번째 자리까지 출력")
    @Test
    void printRateOfReturnTest() {
        printRateOfReturn(90.75, 1);
    }
}