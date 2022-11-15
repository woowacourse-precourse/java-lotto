package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoJudgeTest {
    @DisplayName("로또 1등 당첨 로직 검사")
    @Test
    void lottoFirstWin() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(List.of(1, 2, 3, 4, 5, 6),8);
        LottoJudge lottojudge = new LottoJudge();
        assertThat(lottojudge.judgeWin(lotto,winNumber)).isEqualTo(2000000000);
    }

    @DisplayName("로또 2등 당첨 로직 검사")
    @Test
    void lottoSecondWin() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(List.of(1, 2, 3, 4, 6, 8),5);
        LottoJudge lottojudge = new LottoJudge();
        assertThat(lottojudge.judgeWin(lotto,winNumber)).isEqualTo(30000000);
    }

    @DisplayName("로또 3등 당첨 로직 검사")
    @Test
    void lottoThirdWin() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(List.of(1, 2, 3, 4, 5, 8),10);
        LottoJudge lottojudge = new LottoJudge();
        assertThat(lottojudge.judgeWin(lotto,winNumber)).isEqualTo(1500000);
    }

    @DisplayName("로또 4등 당첨 로직 검사")
    @Test
    void lottoFourthWin() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(List.of(1, 2, 3, 4, 8, 9),10);
        LottoJudge lottojudge = new LottoJudge();
        assertThat(lottojudge.judgeWin(lotto,winNumber)).isEqualTo(50000);
    }

    @DisplayName("로또 5등 당첨 로직 검사")
    @Test
    void lottoFifthWin() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinNumber winNumber = new WinNumber(List.of(1, 2, 3, 7, 8, 9),10);
        LottoJudge lottojudge = new LottoJudge();
        assertThat(lottojudge.judgeWin(lotto,winNumber)).isEqualTo(5000);
    }


}
