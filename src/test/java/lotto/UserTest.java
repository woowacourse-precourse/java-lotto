package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("로또 구입 금액이 1,000 원으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void createCost() {
        assertThatThrownBy(() -> new User(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 당첨 개수 확인하기")
    @Test
    void checkWinning_First() {
        User user = new User(1000);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6));
        user.setLottoNumbers(lottoNumbers);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        user.checkWinning(numbers, bonus);

        assertThat(user.getFirst()).isEqualTo(1);
    }

    @DisplayName("2등 당첨 개수 확인하기")
    @Test
    void checkWinning_Second() {
        User user = new User(1000);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 7));
        user.setLottoNumbers(lottoNumbers);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        user.checkWinning(numbers, bonus);

        assertThat(user.getSecond()).isEqualTo(1);
    }

    @DisplayName("3등 당첨 개수 확인하기")
    @Test
    void checkWinning_Third() {
        User user = new User(1000);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 8));
        user.setLottoNumbers(lottoNumbers);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        user.checkWinning(numbers, bonus);

        assertThat(user.getThird()).isEqualTo(1);
    }

    @DisplayName("4등 당첨 개수 확인하기")
    @Test
    void checkWinning_Fourth() {
        User user = new User(1000);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 8, 9));
        user.setLottoNumbers(lottoNumbers);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        user.checkWinning(numbers, bonus);

        assertThat(user.getFourth()).isEqualTo(1);
    }

    @DisplayName("5등 당첨 개수 확인하기")
    @Test
    void checkWinning_Fifth() {
        User user = new User(1000);
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 8, 9, 10));
        user.setLottoNumbers(lottoNumbers);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        user.checkWinning(numbers, bonus);

        assertThat(user.getFifth()).isEqualTo(1);
    }



}