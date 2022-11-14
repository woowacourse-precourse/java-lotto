package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static lotto.LottoGenerator.getRandomLottoListByCount;

public class LottoGenerateTest {
    @DisplayName("개수가 주어졌을 때 에러없이 로또들이 잘 생성이 되어야한다.")
    @ParameterizedTest(name ="{index} {displayName} count:{0}")
    @ValueSource(ints = {3,6,9})
    void generateLottoListTest(int count){
        assertDoesNotThrow(() -> getRandomLottoListByCount(count));
    }
}
