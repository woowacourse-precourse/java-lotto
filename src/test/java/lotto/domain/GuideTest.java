package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GuideTest {
    @DisplayName("로또 통계 메시지 출력")
    @Test
    void printLottoStatisticsMessage() {
        List<Integer> lottoResult = new ArrayList<Integer>(List.of(1,2,3,4,5));
        Guide.printLottoStatistics(Guide.createLottoStatisticsMessage(lottoResult));
    }

}