package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerNumberListTest extends NsTest {

    @Test
    @DisplayName("당첨번호 목록에 음수가 있을 경우 예외발생")
    public void checkNegativeInWinningNumbers() {
        assertThatThrownBy(() -> new AnswerNumberList(List.of(-2L, 3L, 2L, 1L, 4L, 5L), 7L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 음수가 있을 경우 예외발생")
    public void checkNegativeInBonusNumber() {
        assertThatThrownBy(() -> new AnswerNumberList(List.of(6L, 3L, 2L, 1L, 4L, 5L), -4L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 범위밖 수가 있을 경우 예외 발생")
    public void checkRangeInBonusNumber() {
        assertThatThrownBy(() -> new AnswerNumberList(List.of(6L, 3L, 2L, 1L, 4L, 5L), 47L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 목록에 범위밖 수가 있을 경우 예외 발생")
    public void checkRangeInWinningNumbers() {
        assertThatThrownBy(() -> new AnswerNumberList(List.of(46L, 3L, 2L, 1L, 4L, 5L), 7L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 목록에 보너스 번호가 있을 경우 예외 발생")
    public void checkBonusNumberInWinningNumbers() {
        assertThatThrownBy(() -> new AnswerNumberList(List.of(12L, 3L, 2L, 1L, 4L, 5L), 4L)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 일치할 때")
    public void checkFirstWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 일치할 때")
    public void checkSecondWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.SECOND);
    }

    @Test
    @DisplayName("5개 일치할 때")
    public void checkThirdWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.THIRD);
    }

    @Test
    @DisplayName("4개 일치할 때")
    public void checkFourthWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 8));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.FOURTH);
    }

    @Test
    @DisplayName("3개 일치할 때")
    public void checkFifthWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 9, 8));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치할 때")
    public void checkNothingWinning() {
        Lotto lotto = new Lotto(List.of(1, 2, 20, 11, 9, 8));
        Lotto lotto2 = new Lotto(List.of(1, 23, 20, 11, 9, 8));
        AnswerNumberList answerNumberList = new AnswerNumberList(List.of(1L, 2L, 3L, 4L, 5L, 6L), 7L);
        assertThat(answerNumberList.checkLottoWinning(lotto)).isEqualTo(LottoResult.NOTHING);
        assertThat(answerNumberList.checkLottoWinning(lotto2)).isEqualTo(LottoResult.NOTHING);
    }

    @Override
    protected void runMain() {

    }
}