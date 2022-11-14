package lotto.compareLottoNumber;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import lotto.buyLotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparePrizeNumberWithBonusNumberTest extends NsTest {
    CompareNumber compareNumber = new CompareNumber();

    List<Integer> random = List.of(1, 2, 3, 4, 5, 6);
    int[] prize = {1, 2, 3, 4, 5, 7};
    int[] result = new int[5];
    int bonusNumber = 6;
    List<Lotto> numbers = new ArrayList<>();

    @DisplayName("보너스 번호 까지 포함 하여 배열에 올바르게 포함 되는지 테스트")
    @Test
    void comparePrizeNumberWithBonusNumberTest() {
        run();

        compareNumber.comparePrizeNumberWithBonusNumber(1, result, numbers, prize, bonusNumber);

        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
        assertThat(result[2]).isEqualTo(-1);
        assertThat(result[3]).isEqualTo(1);
        assertThat(result[4]).isEqualTo(0);
    }

    @Override
    protected void runMain() {
        Lotto lotto = new Lotto(random);
        numbers.add(lotto);
    }
}