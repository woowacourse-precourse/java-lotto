package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatingLottoTest {
    CalculatingLotto calculatingLotto = new CalculatingLotto();
    Lotto winningLotto=new Lotto(List.of(1, 2, 3, 4, 5, 6));
    List<Lotto> allLotto=new ArrayList<>();

    @BeforeEach
    void setUp() {
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        allLotto.add(new Lotto(List.of(1, 2, 8, 9, 10, 11)));
        allLotto.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
    }

    @Test
    void findSameNumberTest() {
        assertThat(calculatingLotto.findSameNumber(6,6)).isEqualTo(1);

        assertThat(calculatingLotto.findSameNumber(5,6)).isEqualTo(0);
    }

    @Test
    void checkBonusTest() {
        assertThat(calculatingLotto.checkBonus(6, new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(true);

        assertThat(calculatingLotto.checkBonus(6, new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(false);
    }

    @Test
    void getLottoRankTest() {
        assertThat(calculatingLotto.getLottoRank(6, false)).isEqualTo(1);
        assertThat(calculatingLotto.getLottoRank(6, true)).isEqualTo(1);
        assertThat(calculatingLotto.getLottoRank(5, true)).isEqualTo(2);
        assertThat(calculatingLotto.getLottoRank(5, false)).isEqualTo(3);
        assertThat(calculatingLotto.getLottoRank(4, true)).isEqualTo(4);
        assertThat(calculatingLotto.getLottoRank(4, false)).isEqualTo(4);
        assertThat(calculatingLotto.getLottoRank(3, true)).isEqualTo(5);
        assertThat(calculatingLotto.getLottoRank(3, false)).isEqualTo(5);
        assertThat(calculatingLotto.getLottoRank(2, true)).isEqualTo(0);
        assertThat(calculatingLotto.getLottoRank(1, false)).isEqualTo(0);
    }

    @Test
    void calculateLottoRankTest() {
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(0))).isEqualTo(1);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(1))).isEqualTo(2);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(2))).isEqualTo(3);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(3))).isEqualTo(4);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(4))).isEqualTo(5);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(5))).isEqualTo(0);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(6))).isEqualTo(0);
    }

    @Test
    void calculateAllLottoTest() {
        assertThat(calculatingLotto.calculateAllLotto(winningLotto, 7, allLotto)).isEqualTo(List.of(1,2,3,4,5,0,0));
    }

    @Test
    void countRankTest() {
        assertThat(calculatingLotto.countRank(List.of(1,2,3,4,5,0,0))).isEqualTo(List.of(1,1,1,1,1));
        assertThat(calculatingLotto.countRank(List.of(1,0,0,0,0))).isEqualTo(List.of(1,0,0,0,0));
        assertThat(calculatingLotto.countRank(List.of(1,0,0,5,0))).isEqualTo(List.of(1,0,0,0,1));
        assertThat(calculatingLotto.countRank(List.of(0,0,0,0,0,0))).isEqualTo(List.of(0,0,0,0,0));
    }
}