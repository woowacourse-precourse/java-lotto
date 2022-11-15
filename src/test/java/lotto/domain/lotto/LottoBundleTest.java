package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoBundleTest {


    @Test
    void 로또묶음은_목록화가_가능합니다() {
        var input = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 1),
                List.of(6, 5, 4, 3, 2, 1),
                List.of(4, 3, 2, 1, 5, 6)
        );
        var lottoBundle = new LottoBundle(input);
        var actual = lottoBundle.listUpLotto();
        var expected = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]";
        assertThat(actual).isEqualTo(expected);
    }
}