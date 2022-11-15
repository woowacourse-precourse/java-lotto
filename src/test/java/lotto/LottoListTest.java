package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListTest extends NsTest {

    @DisplayName("1000원 단위로 로또 번호를 생성하는 기능")
    @Test
    public void generateLottoTest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoList lottoList = new LottoList();
            lottoList.generateLotto(1L);
            lottoList.printLottoList();
            assertThat(output()).contains("1개를 구매했습니다.",
                    "[2, 3, 4, 5, 6, 7]");
        }, List.of(2,3,4,5,6,7));
    }

    @DisplayName("오름차순으로 번호 생성 체크")
    @Test
    public void checkDESC() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoList lottoList = new LottoList();
            lottoList.generateLotto(1L);
            lottoList.printLottoList();
            assertThat(output()).contains("1개를 구매했습니다.",
                    "[2, 3, 4, 5, 6, 7]");
        }, List.of(2,4,3,5,6,7));
    }

    @DisplayName("로또 여러개 구매")
    @Test
    public void buyMultiLottos() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoList lottoList = new LottoList();
            lottoList.generateLotto(2L);
            lottoList.printLottoList();
            assertThat(output()).contains("2개를 구매했습니다.",
                    "[2, 3, 4, 5, 6, 7]", "[2, 4, 5, 7, 12, 43]");
        }, List.of(2,4,3,5,6,7), List.of(2,4,12,5,43,7));
    }

    @Override
    protected void runMain() {

    }
}