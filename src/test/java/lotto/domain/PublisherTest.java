package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 발행에 대한 테스트")
class PublisherTest {

    Publisher publisher = new Publisher();

    @ParameterizedTest(name = "금액이 1000으로 나누어떨어지지않으면 예외가 발생한다.")
    @CsvSource(value = {"1001", "999", "123", "2003"})
    void createLottoByInvalidMoney(int money) {
        assertThatThrownBy(() -> publisher.getLottoGroup(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}원이면 {1}장의 로또가 나온다")
    @CsvSource(value = {"1000:1", "2000:2", "10000:10", "4000:4"}, delimiter = ':')
    void getLottoCount(int money, int count) {
        List<Lotto> lottoGroup = publisher.getLottoGroup(money);
        assertEquals(lottoGroup.size(), count);
    }

    @ParameterizedTest(name = "로또는 오름차순으로 정렬되어있다.")
    @CsvSource(value = {"1000", "2000", "12000", "30000"})
    void getSortedLotto(int money) {
        List<Lotto> lottoGroup = publisher.getLottoGroup(money);
        for (Lotto lotto : lottoGroup) {
            List<Integer> parsedLotto = lotto.getLotto();
            System.out.println(Arrays.toString(parsedLotto.toArray()));
            List<Integer> sorted = parsedLotto.stream()
                    .sorted()
                    .collect(Collectors.toList());
            assertEquals(parsedLotto, sorted);
        }
    }
}