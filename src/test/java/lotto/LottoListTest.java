package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
            lottoList.generateLotto();
            lottoList.printLottoList();
            assertThat(output()).contains("1개를 구매했습니다.",
                    "[2, 3, 4, 5, 6, 7]");
        }, List.of(2,3,4,5,6,7));
    }

    @Override
    protected void runMain() {

    }
}