package lotto.compareLottoNumber;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import lotto.buyLotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparePrizeNumberTest extends NsTest {
    CompareNumber compareNumber = new CompareNumber();
    List<Integer> random = List.of(1, 2, 3, 4, 5, 6);
    int[] prize = {1, 2, 3, 4, 5, 7};
    int[] result = new int[5];

    @DisplayName("번호 비교 후 배열에 올바르게 포함 되는지 테스트")
    @Test
    void comparePrizeNumberTest() {
        run();
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(0);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(0);
        assertThat(result[4]).isEqualTo(0);
    }

    @Override
    protected void runMain() {
        Lotto lotto = new Lotto(random);
        List<Lotto> numbers = new ArrayList<>();
        numbers.add(lotto);

        compareNumber.comparePrizeNumber(1, result, numbers, prize);
    }
}
