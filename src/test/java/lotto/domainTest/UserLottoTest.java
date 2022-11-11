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
        UserLotto userLotto = new UserLotto(5);

        //when(실행)
        List<List<Integer>> lotto = userLotto.getUserLotto();

        //then(검증)
        for(List<Integer> numbers : lotto) {
            for (int number : numbers) {
                Assertions.assertThat(number).isBetween(1,45);
            }
        }
    }

    @DisplayName("로또번호는 중복이 존재하면 안된다")
    @Test
    void createLottoDuplicateTest() {
        //given(준비)
        UserLotto userLotto = new UserLotto(5);

        //when(실행)
        List<List<Integer>> lotto = userLotto.getUserLotto();

        //then(검증)
        for(List<Integer> numbers : lotto) {
            Assertions.assertThat(numbers).doesNotHaveDuplicates();
        }
    }

}
