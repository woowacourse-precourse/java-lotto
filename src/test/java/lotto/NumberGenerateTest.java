package lotto;

import lotto.domain.NumberGenerate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGenerateTest {

    private NumberGenerate numberGenerate;

    @BeforeEach
    void setUp() {
        numberGenerate = new NumberGenerate();
    }

    @DisplayName("로또 번호의 개수가 6개다")
    @Test
    void create6RandomNumbers() {
        assertThat(numberGenerate.createRandom().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createUniqueNumbers() {
        List<Integer> randomList = new ArrayList<>(numberGenerate.createRandom());
        Set<Integer> randomSet = new HashSet<>(randomList);
        assertThat(randomList.size()).isEqualTo(randomSet.size());
    }
}
