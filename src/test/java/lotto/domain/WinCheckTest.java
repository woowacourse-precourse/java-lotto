package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.WinCheck.*;
import static org.junit.jupiter.api.Assertions.*;

class WinCheckTest {
    private static Lotto testLotto;
    private static List<Integer> testWinNums;
    private static WinCheck testWinCheck;


    @BeforeAll
    public static void winCheckTestInit() {
        testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        testWinNums = new ArrayList<>(List.of(11, 2, 3, 4, 5, 6));
        StartLotto.bonusNum = 1;
        testWinCheck = new WinCheck(testLotto, testWinNums, StartLotto.bonusNum);
    }

    @DisplayName("일치하는 당첨 번호 수를 올바르게 반화하는 지 확인한다.")
    @Test
    void Result_getMatchCount_테스트() {
        winCheckTestInit();
        assertEquals(testWinCheck.getMatchCount(), 5);
    }

    @DisplayName("보너스 번호 일치 시 참을 반환하는지 확인한다.")
    @Test
    void Result_isBonusMatch_테스트() {
        winCheckTestInit();
        assertTrue(testWinCheck.isBonusMatch());
    }

    @DisplayName("당첨결과가 올바르게 입력되는지 확인한다.")
    @Test
    void Result_checkSave_테스트() {
        winCheckTestInit();
        StartLotto.lotto = new ArrayList<>();
        StartLotto.lotto.add(testLotto);
        StartLotto.winNums = testWinNums;
        StartLotto.winChecks = new ArrayList<>();
        checkSave();
        assertEquals(StartLotto.winChecks.get(0).getMatchCount(), testWinCheck.getMatchCount());
        assertEquals(StartLotto.winChecks.get(0).isBonusMatch(), testWinCheck.isBonusMatch());
    }


}