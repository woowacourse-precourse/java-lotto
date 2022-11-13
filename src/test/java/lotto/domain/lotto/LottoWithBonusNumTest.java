package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoWithBonusNumTest {

    @Test
    void 중복_검사() {
        for(int i=0;i<1000;++i) {
            new LottoWithBonusNum();
        }
    }

}