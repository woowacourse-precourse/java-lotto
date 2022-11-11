package lotto.domainTest;

import lotto.domain.UserLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserLottoTest {

    @DisplayName("로또번호는 1 ~ 45까지의 숫자로 구성되어야 한다")
    @Test
    void createLottoTest() {
        //given(준비)
        UserLotto userLotto = new UserLotto();

        //when(실행)
        List<Integer> lotto = userLotto.createLotto();

        //then(검증)
        for(int lottoNumber : lotto) {
            Assertions.assertThat(lottoNumber).isBetween(1,45);
        }
    }

    @DisplayName("로또번호는 중복이 존재하면 안된다")
    @Test
    void createLottoDuplicateTest() {
        //given(준비)
        UserLotto userLotto = new UserLotto();

        //when(실행)
        List<Integer> lotto = userLotto.createLotto();

        //then(검증)
        Assertions.assertThat(lotto).doesNotHaveDuplicates();
    }

}
