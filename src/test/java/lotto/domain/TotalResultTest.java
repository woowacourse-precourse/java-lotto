package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.TotalResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalResultTest {
    private static Lotto testLotto;
    private static List<Integer> testWinNums;
    private static WinCheck testWinCheck;

    @BeforeAll
    public static void resultTestInit() {
        testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testWinNums = new ArrayList<>(List.of(11, 2, 3, 4, 5, 6));
        testWinCheck = new WinCheck(testLotto, testWinNums, 1);
        StartLotto.winChecks = new ArrayList<>();
        StartLotto.winChecks.add(testWinCheck);
        new TotalResult();
    }

    @DisplayName("등 수 반환이 제대로 이루어지는 지 확인한다.")
    @Test
    void Result_getCount_테스트() {
        resultTestInit();
        assertEquals(getCount(1), 0);

    }

    @DisplayName("등 수 추가가 제대로 이루어지는 지 확인한다.")
    @Test
    void Result_addResult_테스트() {
        resultTestInit();
        addResult(testWinCheck);
        assertEquals(getCount(1), 0);
        assertEquals(getCount(2), 2);
        assertEquals(getCount(3), 0);
        assertEquals(getCount(4), 0);
        assertEquals(getCount(5), 0);
    }

    @DisplayName("예시 입력 후 등 수가 올바르게 기록되는 지 확인한다.")
    @Test
    void Result_객체_생성_테스트() {
        resultTestInit();
        assertEquals(getCount(1), 0);
        assertEquals(getCount(2), 1);
        assertEquals(getCount(3), 0);
        assertEquals(getCount(4), 0);
        assertEquals(getCount(5), 0);
    }

    @DisplayName("총 당첨 금액을 올바르게 계산하는지 확인한다.")
    @Test
    void Result_totalPrize_테스트() {
        resultTestInit();
        assertEquals(totalPrize(), new BigDecimal(30000000));
    }

    @DisplayName("수익률 계산이 올바르게 되는지 확인한다.")
    @Test
    void Result_calculate_테스트() {
        resultTestInit();
        StartLotto.payment = 30000;
        assertEquals(calculate(), "100,000.0");
    }
}