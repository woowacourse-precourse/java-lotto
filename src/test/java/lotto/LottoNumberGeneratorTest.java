package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("6개의 로또 번호를 생성해주는지")
    @Test
    void generateRandomLottoNumber() {

        assertEquals(pickUniqueNumbersInRange(1, 45, 6).size(), 6);

    }

    @DisplayName("돈을 넣은 만큼 로또 번호를 생성하고 그것을 배열에 담는지 확인")
    @Test
    void generateRandomLottoNumberAccordingToInputMoney() {

        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<List<Integer>> lottoList = generator.generateLottoNumber(14000);

        assertAll(
                () -> assertEquals(lottoList.size(), 14),
                () -> assertEquals(lottoList.get(0).size(), 6)
        );
    }
}