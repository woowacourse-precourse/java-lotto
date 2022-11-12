package lotto.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class NumberMatchTest {

    @Test
    void 같은숫자_갯수_반환_테스트() {

        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> winningNum = Arrays.asList(11, 2, 3, 4, 5, 6);

        NumberMatcher numberMatch = new NumberMatcher();
        int result = numberMatch.countSameNumber(lottoNum, winningNum);
        Assertions.assertEquals(5, result);
    }
}