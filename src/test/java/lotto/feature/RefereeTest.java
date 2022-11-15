package lotto.feature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Referee;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    Referee referee = new Referee();

    @Test
    void test_compare() {
        List<Integer> myLotto = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 27, 36));
        List<Integer> winLotto_first = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 27, 36));
        List<Integer> winLotto_second = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 29, 36));
        List<Integer> winLotto_third = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 27, 30));
        List<Integer> winLotto_firth = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 29, 30));
        List<Integer> winLotto_fifth = new ArrayList<>(Arrays.asList(1, 4, 9, 20, 29, 30));
        List<Integer> winLotto_fail = new ArrayList<>(Arrays.asList(1, 4, 10, 20, 29, 30));
        int bonus = 2;
        int bonus2 = 27;

        assertThat(referee.compare(myLotto, winLotto_first, bonus)).isEqualTo("FIRST_WIN");
        assertThat(referee.compare(myLotto, winLotto_second, bonus2)).isEqualTo("SECOND_WIN");
        assertThat(referee.compare(myLotto, winLotto_third, bonus)).isEqualTo("THIRD_WIN");
        assertThat(referee.compare(myLotto, winLotto_firth, bonus)).isEqualTo("FIRTH_WIN");
        assertThat(referee.compare(myLotto, winLotto_fifth, bonus)).isEqualTo("FIFTH_WIN");
        assertThat(referee.compare(myLotto, winLotto_fail, bonus)).isEqualTo("");
    }
}

