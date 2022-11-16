package lotto.domain;

import lotto.dto.LottoResultDto;
import lotto.util.ResultPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.util.ResultPrice.values;

class CheckerTest {
    private static final List<Lotto> lottoGroup = List.of(
            new Lotto(List.of(2, 3, 4, 5, 6, 7)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8)),
            new Lotto(List.of(4, 5, 6, 7, 8, 9)),
            new Lotto(List.of(40, 41, 42, 43, 44, 45))
    );

    private static final LottoResultDto lottoResultDto = new LottoResultDto(
            List.of(1, 2, 3, 4, 5, 6), 8
    );

    Checker checker = new Checker(lottoResultDto);


    @DisplayName("totalScore는 1~5등의 결과를 모두 가지고있다.")
    @Test
    void get() {
        Map<ResultPrice, Integer> totalScore = checker.getTotalScore(lottoGroup);

        Arrays.stream(values())
                .forEach(totalScore::get);
    }


}