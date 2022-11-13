package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    MockedStatic.Verification verification;
    List<Integer> expected;

    @BeforeEach
    void init() {
        verification = LottoGenerator::createRandomLottoNumber;
        expected = List.of(6, 1, 2, 3, 32, 8);
    }

    @DisplayName("로또와 당첨 번호를 비교해서 일치하는 개수를 반환한다.")
    @Test
    void getMatchCountByLottoAndUserLotto() {
        try (MockedStatic<LottoGenerator> randoms = Mockito.mockStatic(LottoGenerator.class)) {
            randoms.when(verification).thenReturn(expected);

            Lotto lotto = Lotto.create();
            List<Integer> userLotto = List.of(1, 2, 3, 4, 5, 6);

            int lottoWinCount = lotto.findLottoWinCount(userLotto);

            assertThat(lottoWinCount).isEqualTo(4);
        }
    }
}
