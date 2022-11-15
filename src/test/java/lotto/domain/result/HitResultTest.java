package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HitResultTest {

    private LottoGroup lottoGroup;

    @BeforeEach
    void setUp() {
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        lottoGroup = new LottoGroup(3, fixedNumberGenerator); // [1, 2, 3, 4, 5, 6]
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', '7', 0, 0, 0, 0, 3",
            "'1,2,3,4,5,10', '6', 0, 0, 0, 3, 0",
            "'1,2,3,4,5,10', '7', 0, 0, 3, 0, 0",
            "'1,2,3,4,10,11', '7', 0, 3, 0, 0, 0",
            "'1,2,3,10,11,12', '7', 3, 0, 0, 0, 0",
            "'1,2,10,11,12,13', '7', 0, 0, 0, 0, 0"
    })
    public void calculateMatchResults(String winningNumbers, String bonus, int hit3, int hit4, int hit5, int hit5WithBonus, int hit6) {
        System.out.println("winningNumbers = " + winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(bonus, winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(hit3, hit4, hit5, hit5WithBonus, hit6));
    }
}
