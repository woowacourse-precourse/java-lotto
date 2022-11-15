package lotto.utils;

import lotto.domains.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberConverterTest {
    private static List<Integer> VALID_NUMBERS;

    @BeforeEach
    void setUp() {
        VALID_NUMBERS = List.of(1,2,3,4,5,6);
    }

    @Test
    void convertToStringWithValidNumbers() {
        assertThat(LottoNumberConverter.convertToString(VALID_NUMBERS))
                .isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @Test
    void convertToWinningNumberToListWithWinningNumber() {
        assertThat(LottoNumberConverter.convertWinningNumberToList("1,2,3,4,5,6"))
                .isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void convertToWinningNumberToListWithInvalidWinningNumber() {
        assertThatThrownBy(() ->LottoNumberConverter.convertWinningNumberToList("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertTo2DimensionalLisWithListOfLotto() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Lotto> lotteries = List.of(lotto);

        assertThat(LottoNumberConverter.convertTo2DimensionalList(lotteries))
                .contains(List.of(1,2,3,4,5,6))
                .isNotEmpty()
                .isNotNull();
    }

}
