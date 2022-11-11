package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @DisplayName("주어진 가격으로 적절하게 로또를 구매하는 지 검증한다.")
    @ParameterizedTest(name = "{index} ==> 주어진 값이 {0}원이라면 로또를 {1}장 구매한다.")
    @CsvSource(value = {"20000:20", "10000:10", "1000:1", "2000:2", "500:0", "0:0", "12000:12", "12500:12"}, delimiter = ':')
    void buyLotto(int source, int expected) {
        User user = new User();
        user.buyLotto(source);
        int actual = user.getLottos().size();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 가격으로 로또를 구매하고, 당첨내역이 적절히 계산되는지 검증한다.")
    @ParameterizedTest(name = "{index} ==> 주어진 값이 {0}원이라면  {1}장의 추첨 기록이 있어야한다.")
    @CsvSource(value = {"20000:20", "10000:10", "1000:1", "2000:2", "500:0", "0:0", "12000:12", "12500:12"}, delimiter = ':')
    void getLottoWinningHistory(int source, int expected) {
        User user = new User();
        user.buyLotto(source);
        int actual = user.getWinningHistory(List.of(1, 2, 3, 4, 5, 6), 7).stream().reduce(0, Integer::sum);
        assertThat(actual).isEqualTo(user.getLottos().size());
    }
}