package lotto.controller;

import lotto.UI.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {


    private LottoGame lottoGame;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
    }

    @DisplayName("구매금액 입력시 1,000원 단위가 아니라면 예외가 발생한다")
    @Test
    void 같은_번호_개수_출력() {

        List<Integer> TestUser1 = List.of(1,2,3,4,5,6);
        List<Integer> TestComputer1 = List.of(1,2,3,4,5,7);
        Integer BonusNumber1 = 11;

        List<Integer> TestUser2 = List.of(1,2,3,4,5,6);
        List<Integer> TestComputer2 = List.of(1,2,3,4,5,7);
        Integer BonusNumber2 = 7;

        // 3등 5개 일치
        assertEquals(5,lottoGame.compareLottoNumber(TestUser1,TestComputer1,BonusNumber1));

        // 2등 5개 일치, 보너스 볼 일치(+2)
        assertEquals(7,lottoGame.compareLottoNumber(TestUser2,TestComputer2,BonusNumber2));
    }
}