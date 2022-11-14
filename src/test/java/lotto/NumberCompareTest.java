package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumberCompare;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.EnumOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto
 * fileName : NumberCompareTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */


public class NumberCompareTest {
    @DisplayName("2등 당첨")
    @Test
    @EnumSource(value = Rank.class)
    void NumberCompareTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 11);
        int bonusNumber = 11;
        assertThat(NumberCompare.compare(numbers, randomNumbers, bonusNumber))
                .isEqualTo(Rank.TWO);
    }
}