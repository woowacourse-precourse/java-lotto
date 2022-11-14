package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {
    @DisplayName("1 ~ 45 로또 번호를 생성한다.")
    @Test
    void 로또_번호_생성() {
        List<Integer> numbers = LottoGenerator.getInstance.createLotto();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).isEqualTo(numbers);
    }

    @DisplayName("뽑은 번호를 오름차순으로 정렬한다.")
    @Test
    void 로또_번호_오름차순() {
        List<Integer> numbers = Arrays.asList(6,5,4,3,2,1);
        List<Integer> sortNumbers = LottoGenerator.getInstance.sortLotto(numbers);
        assertThat(sortNumbers).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("구매자가 구매한 장수만큼 로또를 발급한다.")
    @Test
    void 로또_번호_발급() {
        int pages = 3;
        List<Lotto> lotto = LottoGenerator.getInstance.issueLotto(pages);
        assertThat(lotto.size()).isEqualTo(3);
    }
}
