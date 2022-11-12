package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    @DisplayName("1 ~ 45 로또 번호를 생성한다.")
    @Test
    void 로또_번호_생성() {
        List<Integer> numbers = lottoGenerator.createLotto();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).isEqualTo(numbers);
    }

    @DisplayName("뽑은 번호를 오름차순으로 정렬한다.")
    @Test
    void 로또_번호_오름차순() {
        List<Integer> numbers = List.of(6,5,4,3,2,1);
        List<Integer> sortNumbers = lottoGenerator.sortLotto(numbers);
        assertThat(List.of(1,2,3,4,5,6)).isEqualTo(sortNumbers);
    }
}
