package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRepositoryTest {

    private LottoRepository lottoRepository;

    @TestFactory
    @DisplayName("LottoRepository Test")
    Stream<DynamicTest> lottoRepositoryTest() {
        lottoRepository = new LottoRepository();

        return Stream.of(
                DynamicTest.dynamicTest("Create Test 로또번호 생성을 테스트한다.", () -> {
                    Lotto result = lottoRepository.create();
                    List<Integer> resultNumber = result.getNumbers();

                    assertThat(resultNumber.size())
                            .isEqualTo(LottoEnum.LOTTO.getSize());

                    assertThat(resultNumber.get(0))
                            .isGreaterThanOrEqualTo(LottoEnum.LOTTO.getMinNum());

                    assertThat(resultNumber.get(LottoEnum.LOTTO.getSize()-1))
                            .isGreaterThanOrEqualTo(LottoEnum.LOTTO.getMinNum())
                            .isLessThanOrEqualTo(LottoEnum.LOTTO.getMaxNum());
                })
        );
    }
}
