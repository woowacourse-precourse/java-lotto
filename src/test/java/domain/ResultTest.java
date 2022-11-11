package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    Result result;
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @BeforeEach
    void setUp() {
        this.result = new Result();
    }

    @DisplayName("로또 당첨 번호와 구매자의 번호가 일치하는 개수를 반환한다.")
    @Test
    void countMatchingNumberTest1() {
        List<Integer> userNumbers = List.of(3, 4, 5, 1, 2, 6);

        int matchingCount = result.countMatchingNumber(winningNumbers, userNumbers);

        Assertions.assertThat(matchingCount).isEqualTo(6);
    }

    @DisplayName("로또 당첨 번호와 구매자의 번호가 일치하는 개수를 반환한다.")
    @Test
    void countMatchingNumberTest2() {
        List<Integer> userNumbers = List.of(5, 10, 15, 20, 25, 30);

        int matchingCount = result.countMatchingNumber(winningNumbers, userNumbers);

        Assertions.assertThat(matchingCount).isEqualTo(1);
    }

    @DisplayName("로또 당첨 번호와 구매자의 번호가 일치하는 개수를 반환한다.")
    @Test
    void countMatchingNumberTest3() {
        List<Integer> userNumbers = List.of(1, 3, 7, 9, 11, 13);

        int matchingCount = result.countMatchingNumber(winningNumbers, userNumbers);

        Assertions.assertThat(matchingCount).isEqualTo(2);
    }

    @DisplayName("구매자의 번호가 보너스번호와 일치하는지 확인한다.")
    @Test
    void isMatchingBonusNumberTest1() {
        List<Integer> userNumbers = List.of(1, 3, 4, 5, 8, 9);
        int bonusNumber = 1;

        boolean matchingBonusNumber = result.isMatchingBonusNumber(userNumbers, bonusNumber);

        Assertions.assertThat(matchingBonusNumber).isEqualTo(true);
    }

    @DisplayName("구매자의 번호가 보너스번호와 일치하는지 확인한다.")
    @Test
    void isMatchingBonusNumberTest2() {
        List<Integer> userNumbers = List.of(1, 3, 4, 5, 8, 9);
        int bonusNumber = 2;

        boolean matchingBonusNumber = result.isMatchingBonusNumber(userNumbers, bonusNumber);

        Assertions.assertThat(matchingBonusNumber).isEqualTo(false);
    }
}
