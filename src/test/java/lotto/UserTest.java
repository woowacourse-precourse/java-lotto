package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class UserTest {

    @DisplayName("숫주가 아닌 값이 주어지면 예외가 발생한다.")
    @Test
    void createUserByNonNumericString() {
        assertThatThrownBy(() -> new User("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createUserByInvalidPrice() {
        assertThatThrownBy(() -> new User("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoList 생성 테스트(List 길이, 각 원소의 numbers의 길이, numbers 원소 중복 여부 및 범위)")
    @Test
    void createLottoListTest() {
        User user = new User("12000");
        List<Lotto> lottoList = user.getLottoList();

        assertThat(lottoList.size()).isEqualTo(12);

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();

            //List 중복 검사
            HashSet<Integer> hashSet = new HashSet<>(numbers);
            assertThat(hashSet.size()).isEqualTo(6);

            //List 원소 범위 검사
            for (Integer number : numbers) {
                assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
            }
        }
    }
}