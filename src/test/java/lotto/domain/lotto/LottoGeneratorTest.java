package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("[성공] 랜덤한 로또 번호 6개를 생성한 로또 객체 만들기")
    @Test
    public void createLottoWithRandomNumbers() {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("[성공] 랜덤한 로또 번호 6개를 생성한 로또 객체 만들기 - 정렬 확인")
    @Test
    public void createLottoWithSortedRandomNumbers() {
        Lotto lotto = LottoGenerator.createLottoWithRandomNumbers();
        List<Integer> originNumbers = lotto.getNumbers();
        List<Integer> sortedNumbers = lotto.getNumbers().stream().sorted().collect(Collectors.toList());
        assertThat(originNumbers).isEqualTo(sortedNumbers);
    }


}
