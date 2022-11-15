package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또가 잘 발행된다.")
    @Test
    public void createLotto() {
        assertDoesNotThrow(LottoGenerator::generate);
    }

    @DisplayName("리스트가 주어졌을 때 로또가 그대로 발행된다.")
    @Test
    public void generateLottoByNumbers() {
        List<Integer> manualNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = LottoGenerator.generateByNumberList(manualNumbers);
        assertThat(lotto.getNumbers()).contains(manualNumbers.toArray(Integer[]::new));
    }
}