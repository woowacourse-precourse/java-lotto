package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.exception.Validator.validateDifferentLottoNumbers;
import static lotto.common.exception.Validator.validateRangeLottoNumbers;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    LottoTicket lottoTicket = new LottoTicket();

    @DisplayName("로또 번호 랜덤 생성 테스트 - 중복/6개")
    @Test
    void generateTest() {
        Lotto lotto = lottoTicket.generate();
        assertDoesNotThrow(()->{
            validateDifferentLottoNumbers(lotto.get());
        });
    }

    @DisplayName("로또 번호 랜덤 생성 테스트 - 범위")
    @Test
    void generateRangeTest() {
        Lotto lotto = lottoTicket.generate();
        assertDoesNotThrow(()->{
            validateRangeLottoNumbers(lotto.get());
        });
    }
}