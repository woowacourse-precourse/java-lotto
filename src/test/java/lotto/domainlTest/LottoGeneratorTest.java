package lotto.domainlTest;

import lotto.domain.LottoGenerator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("임의의 로또 번호를 생성하여 6개인지 확인한다.")
    public void createLottoTest() {
        int numberOfLottoNumbers = 6;
        List<Integer> lotto = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        lotto = lottoGenerator.createLotto();
        assertThat(lotto.size()).isEqualTo(numberOfLottoNumbers);
    }

    @Test
    @DisplayName("구매한 로또의 수만큼 로또를 발행하는지 확인한다.")
    public void generateLottoOfBuyerTest() {
        int numberOfLotto = 8;
        List<Lotto> generatedLotto;
        LottoGenerator lottoGenerator = new LottoGenerator();
        generatedLotto = lottoGenerator.generateLottoOfBuyer(numberOfLotto);
        assertThat(generatedLotto.size()).isEqualTo(numberOfLotto);
    }

    @Test
    @DisplayName("발행한 로또가 오름차순으로 정렬되는지 확인한다.")
    public void checkLottoSorting() {
        List<Integer> expectedLotto = List.of(1, 2, 3, 4, 5, 6);
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> generatedLottoNumbers = List.of(2, 6, 3, 4, 1, 5);
        Stream<Integer> sortedLottoNumbers = lottoGenerator.sortLottoNumbers(new Lotto(generatedLottoNumbers));
        assertThat(sortedLottoNumbers.toArray()).containsExactlyElementsOf(expectedLotto);
    }

    @Test
    @DisplayName("오름차순으로 정렬된 로또가 문자열로 변환되는지 확인한다.")
    public void checkSortedLottoResult() {
        String expectedLotto = "[1, 2, 3, 4, 5, 6]\n";
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> generatedLottoNumbers = List.of(2, 6, 3, 4, 1, 5);
        Stream<Integer> sortedLottoNumbers = lottoGenerator.sortLottoNumbers(new Lotto(generatedLottoNumbers));
        String result = lottoGenerator.createLottoNumberFormat(sortedLottoNumbers);
        assertThat(result).isEqualTo(expectedLotto);
    }

    @Test
    @DisplayName("발행한 로또들을 오름차순으로 정렬한 뒤 문자열로 변환되는지 확인한다.")
    public void checkSortedLotteriesResult() {
        String expectedLotto = "[1, 2, 3, 4, 5, 6]\n[2, 3, 4, 5, 6, 7]\n";
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> generatedLotteries = new ArrayList<>();
        generatedLotteries.add(new Lotto(List.of(2, 6, 3, 4, 1, 5)));
        generatedLotteries.add(new Lotto(List.of(2, 6, 5, 7, 4, 3)));
        List<String> sortedLotteries = new ArrayList<>();
        String result;
        for (Lotto lotto : generatedLotteries) {
            Stream<Integer> sortedLottoNumbers = lottoGenerator.sortLottoNumbers(lotto);
            sortedLotteries.add(lottoGenerator.createLottoNumberFormat(sortedLottoNumbers));
        }
        result = String.join("", sortedLotteries);
        assertThat(result).isEqualTo(expectedLotto);
    }
}
