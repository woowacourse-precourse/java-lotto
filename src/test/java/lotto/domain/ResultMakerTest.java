package lotto.domain;

import lotto.domain.result.Result;
import lotto.domain.result.ResultMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultMakerTest {
    @Test
    void testCompareWithLotto() {
        ResultMaker result = new ResultMaker(List.of(1, 2, 3, 4, 5, 6), 7);
        Result gameResult = result.getTheResult(List.of(1, 2, 3, 12, 13, 14));
        assertEquals(3, gameResult.getAccordedNumbers());
    }
}