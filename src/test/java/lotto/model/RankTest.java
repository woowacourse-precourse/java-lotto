package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    private static final int LOTTO_SIZE = 6;

    private static void validate(List<Lotto> expected, Lotto result, int specialNumber, Rank first) {
        ResultLotto resultLotto = new ResultLotto(result, Arrays.asList(specialNumber), 1);
        assertThat(Rank.getRanks(expected, resultLotto)).isEqualTo(Arrays.asList(first));
    }

    private static void emptyValidate(List<Lotto> expected, Lotto result, int specialNumber) {
        ResultLotto resultLotto = new ResultLotto(result, Arrays.asList(specialNumber), 1);
        assertThat(Rank.getRanks(expected, resultLotto)).isEqualTo(Arrays.asList());
    }

    @DisplayName("1등이 되는경우")
    @Test
    public void firstTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE);
        int specialNumber = 10;
        validate(expected, result, specialNumber, Rank.FIRST);
    }

    @DisplayName("2등이 되는경우")
    @Test
    public void secondTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7), LOTTO_SIZE);
        int specialNumber = 6;
        validate(expected, result, specialNumber, Rank.SECOND);
    }

    @DisplayName("3등이 되는경우")
    @Test
    public void thirdTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7), LOTTO_SIZE);
        int specialNumber = 10;
        validate(expected, result, specialNumber, Rank.THIRD);
    }

    @DisplayName("4등이 되는경우")
    @Test
    public void fourthTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 7), LOTTO_SIZE);
        int specialNumber = 10;
        validate(expected, result, specialNumber, Rank.FOURTH);
    }

    @DisplayName("5등이 되는경우")
    @Test
    public void fifthTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 3, 11, 9, 7), LOTTO_SIZE);
        int specialNumber = 10;
        validate(expected, result, specialNumber, Rank.FIFTH);
    }

    @DisplayName("2개 맞는경우")
    @Test
    public void twoCorrectTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 2, 13, 11, 9, 7), LOTTO_SIZE);
        int specialNumber = 10;
        emptyValidate(expected, result, specialNumber);
    }

    @DisplayName("1개 맞는경우")
    @Test
    public void oneCorrectTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(1, 12, 13, 11, 9, 7), LOTTO_SIZE);
        int specialNumber = 10;
        emptyValidate(expected, result, specialNumber);
    }

    @DisplayName("0개 맞는경우")
    @Test
    public void zeroCorrectTest() {
        List<Lotto> expected = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), LOTTO_SIZE));
        Lotto result = new Lotto(Arrays.asList(21, 12, 13, 11, 9, 7), LOTTO_SIZE);
        int specialNumber = 10;
        emptyValidate(expected, result, specialNumber);
    }
}