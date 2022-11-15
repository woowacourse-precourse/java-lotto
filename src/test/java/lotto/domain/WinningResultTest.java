package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    public static final int CORRECT_COUNT=5;
    WinningResult winningResult;
    Lotto lotto;
    WinningLotto winningLotto;

    @BeforeEach
    void setup(){
        winningResult=new WinningResult();
        lotto=new Lotto(List.of(1,2,3,4,5,6));
        winningLotto=new WinningLotto(new Lotto(List.of(1,2,3,4,5,8)), 6);
    }

    @DisplayName("당첨 번호와 사용자의 로또 번호 일치하는 개수를 제대로 찾는지 확인")
    @Test
    void calcCorrectLotto(){
        assertEquals(CORRECT_COUNT,winningResult.calcCorrectLotto(lotto, winningLotto));
    }

    @DisplayName("당첨번호와 사용자의 로또 번호 일치하는 개수가 5일 때 보너스 번호가 사용자 로또 번호와 일치한다면 true 반환하는지 확인")
    @Test
    void isCorrectBonus(){
        assertTrue(winningResult.isCorrectBonus(CORRECT_COUNT, lotto, winningLotto));
    }
}