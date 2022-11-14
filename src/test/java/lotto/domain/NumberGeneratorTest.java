package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @DisplayName("구입 금액 만큼 로또 번호를 생성한다.")
    @Test
    void createLottoNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator("12000");
        int numOfCreatedLotto = numberGenerator.collectionOfLottoNumbers.size();
        assertEquals(12, numOfCreatedLotto);
    }


}