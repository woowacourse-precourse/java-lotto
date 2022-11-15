package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoCheckerTest {

    static LottoChecker lottoChecker;

    @BeforeAll
    static void beforeAll() {
        systemSetIn("1,2,3,4,5,6\n7");
        lottoChecker = new LottoChecker();
    }

    @DisplayName("로또 등수 체크 검사")
    @Test
    void test() {
        Lotto lotto_1st = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto_2nd = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto_3rd = new Lotto(List.of(1,2,3,4,5,40));
        Lotto lotto_4th = new Lotto(List.of(1,2,3,4,40,41));
        Lotto lotto_5th = new Lotto(List.of(1,2,3,40,41,42));
        Lotto lotto_lose = new Lotto(List.of(40,41,42,43,44,45));

        assertAll(
                () -> assertThat(lottoChecker.check(lotto_1st)).isEqualTo(LottoRanking.RANK_1),
                () -> assertThat(lottoChecker.check(lotto_2nd)).isEqualTo(LottoRanking.RANK_2),
                () -> assertThat(lottoChecker.check(lotto_3rd)).isEqualTo(LottoRanking.RANK_3),
                () -> assertThat(lottoChecker.check(lotto_4th)).isEqualTo(LottoRanking.RANK_4),
                () -> assertThat(lottoChecker.check(lotto_5th)).isEqualTo(LottoRanking.RANK_5),
                () -> assertThat(lottoChecker.check(lotto_lose)).isEqualTo(LottoRanking.LOSE)
        );
    }

    static void systemSetIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
