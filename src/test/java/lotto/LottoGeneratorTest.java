package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class LottoGeneratorTest {

    @Test
    public void generateLottoNumbers() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(List.of(8, 21, 23, 41, 42, 43));
            assertThat(LottoGenerator.generatLottos("1000").get(0).getNumbers())
                    .isEqualTo(List.of(8, 21, 23, 41, 42, 43));
        }
    }

    @Test
    public void generateLottoNumbersFail() {
        assertThatThrownBy(()->LottoGenerator.generatLottos("900")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void generateLottoNumbersFail2() {
        assertThatThrownBy(()->LottoGenerator.generatLottos("9000a")).isInstanceOf(IllegalArgumentException.class);
    }

}