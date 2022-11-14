package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompareResultTest {
    CompareResult compareResult;

    @BeforeEach
    void beforeEach() {
        compareResult = CompareResult.getDefault();
    }

    @Test
    void 로또의_숫자와_당첨_숫자가_몇_개_일치하는지_세는_기능() {
        CompareResult expected = new CompareResult(3, false);

        compareResult = compareResult.oneMoreNumberMatched();
        compareResult = compareResult.oneMoreNumberMatched();
        compareResult = compareResult.oneMoreNumberMatched();

        assertThat(compareResult).isEqualTo(expected);
    }

    @Test
    void 로또의_숫자에_보너스_숫자가_포함되는지_기록하는_기능() {
        CompareResult expected = new CompareResult(0, true);

        compareResult = compareResult.bonusNumberFound();

        assertThat(compareResult).isEqualTo(expected);
    }
}