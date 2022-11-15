package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyseTest {
    @DisplayName("구입한 로또번호와 당첨 번호를 비교하여 일치하는 갯수를 출력한다:4개")
    @Test
    void isRightCompare() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> buyNumber = Arrays.asList(1, 2, 3, 7, 5, 8);
        int winNum = 8;

        Lotto winLotto = new Lotto(winNumber);
        Lotto buyLotto = new Lotto(buyNumber);

        int result = Analyse.containNumber(winLotto, buyLotto, winNum);

        Assertions.assertThat(result).isEqualTo(4);
    }

    @DisplayName("구입한 로또번호와 당첨 번호를 비교하여 일치하는 갯수를 출력한다:5개+보너스")
    @Test
    void isRightCompare2() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> buyNumber = Arrays.asList(1, 2, 3, 7, 5, 8);
        int winNum = 7;

        Lotto winLotto = new Lotto(winNumber);
        Lotto buyLotto = new Lotto(buyNumber);

        int result = Analyse.containNumber(winLotto, buyLotto, winNum);

        Assertions.assertThat(result).isEqualTo(7);
    }

    @DisplayName("구입한 로또번호와 당첨 번호를 비교하여 일치하는 갯수를 출력한다:6개")
    @Test
    void isRightCompare3() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> buyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int winNum = 7;

        Lotto winLotto = new Lotto(winNumber);
        Lotto buyLotto = new Lotto(buyNumber);

        int result = Analyse.containNumber(winLotto, buyLotto, winNum);

        Assertions.assertThat(result).isEqualTo(6);
    }

}