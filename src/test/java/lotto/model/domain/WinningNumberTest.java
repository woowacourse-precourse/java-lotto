package lotto.model.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void 한개_로또의_등수_게산하기() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", "7");
        Lotto fifthLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourthLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank fifthRank = winningNumber.computeRank(fifthLotto);
        Rank fourthRank = winningNumber.computeRank(fourthLotto);
        Rank thirdRank = winningNumber.computeRank(thirdLotto);
        Rank secondRank = winningNumber.computeRank(secondLotto);
        Rank firstRank = winningNumber.computeRank(firstLotto);

        Assertions.assertThat(fifthRank)
                .isEqualTo(Rank.FIFTH);
        Assertions.assertThat(fourthRank)
                .isEqualTo(Rank.FOURTH);
        Assertions.assertThat(thirdRank)
                .isEqualTo(Rank.THIRD);
        Assertions.assertThat(secondRank)
                .isEqualTo(Rank.SECOND);
        Assertions.assertThat(firstRank)
                .isEqualTo(Rank.FIRST);
    }
}