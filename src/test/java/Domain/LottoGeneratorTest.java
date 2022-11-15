package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("사용자가 구입할 수 있는 수량 만큼 로또를 생성한다.")
    void issueLotto() {
        //given
        String userPrice = "3000";
        int expectAmount = 3;
        LottoGenerator lottoGenerator = new LottoGenerator(userPrice);

        //when
        int amount = lottoGenerator.issueLotto().size();

        //then
        assertEquals(expectAmount, amount);
    }

    @Test
    void createLottoNumbers() {
    }
}