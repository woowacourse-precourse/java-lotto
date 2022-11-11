package lotto.domain;

//import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.utils.MessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    
    @Test
    @DisplayName("로또를 구매할 수 있다.")
    void test1() {
        // given
        setInput("1000");
        User user = new User();

        // when
        user.buyLotto();

        // then
        assertThat(user.getBuyAmount()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("발행한 로또 수량을 알 수 있다.")
    void test2() {
        // given
        String money = "3000";
        setInput(money);
        int expected = Integer.parseInt(money) / 1000;
        User user = new User();

        // when
        user.buyLotto();
        int actual = user.getBuyAmount();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 번호를 제외하고 몇 개의 번호가 일치한지 알 수 있다.")
    void test3() {
        // given
        List<Integer> userLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 10, 11, 12, 13);
        Lotto lotto = new Lotto(userLottoNumbers);

        // when
        int count = lotto.correctCount(winningLottoNumbers);

        // then
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호가 일치하면 true를 리턴한다.")
    void test4() {
        // given
        List<Integer> userLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 10, 11, 12, 6);
        Lotto lotto = new Lotto(userLottoNumbers);

        // when
        boolean actual = lotto.isMatchBonusNumber(winningLottoNumbers);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 일치하지 않으면 false를 리턴한다.")
    void test5() {
        // given
        List<Integer> userLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 10, 11, 12, 13);
        Lotto lotto = new Lotto(userLottoNumbers);

        // when
        boolean actual = lotto.isMatchBonusNumber(winningLottoNumbers);

        // then
        assertThat(actual).isFalse();
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
