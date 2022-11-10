package lotto.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LogicTest {

    @Test
    void 같은숫자_갯수_반환_테스트() {

        int[] lottoNum = {1, 2, 3, 4, 5, 6};

        int[] winningNum = {11, 2, 33, 4, 55, 6};
        Logic logic = new Logic();
        int result = logic.countSameNumber(lottoNum, winningNum);
        Assertions.assertEquals(3, result);
    }
}