package lotto.feature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Judgement;
import org.junit.jupiter.api.Test;

public class JudgementTest {

    Judgement judgement = new Judgement();

    @Test
    void test_sameNumberCount() {
        List<Integer> myLotto = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 27, 36));
        List<Integer> winLotto = new ArrayList<>(Arrays.asList(1, 6, 9, 10, 17, 36));

        assertThat(judgement.sameNumberCount(myLotto, winLotto)).isEqualTo(3);
    }

    @Test
    void test_containBonusNumber() {
        List<Integer> myLotto = new ArrayList<>(Arrays.asList(1, 4, 9, 19, 27, 36));
        int bounusNumber1 = 27;
        int bounusNumber2 = 25;

        assertThat(judgement.containBonusNumber(myLotto, bounusNumber1)).isEqualTo(true);
        assertThat(judgement.containBonusNumber(myLotto, bounusNumber2)).isEqualTo(false);
    }
}
