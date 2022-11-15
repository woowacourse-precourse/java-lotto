package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserLottoTest {
    private static final int LOTTO_COUNT = 8;
    private static final int BUY_MONEY=8000;
    UserLotto userLotto;
    @BeforeEach
    void setup(){
        userLotto=new UserLotto(BUY_MONEY);
    }
    @DisplayName("구매한 로또 개수만큼 로또 번호를 발행하는지 확인")
    @Test
    void makeLottoNumberListTest(){
        assertEquals(LOTTO_COUNT, userLotto.getLottos().size());
    }

}