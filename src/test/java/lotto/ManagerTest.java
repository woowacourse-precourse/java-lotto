package lotto;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManagerTest {
    @DisplayName("로또 수량 확인")
    @Test
    void getAmountFromPrice() {
        Manager manager = new Manager();
        int result = manager.getAmount(20000);

        assertThat(result).isEqualTo(20);
    }

    @DisplayName("잘못된 금액일경우 예외발생")
    @ParameterizedTest(name = "{displayName} ({0}원)")
    @ValueSource(ints = {15500, 900, 0})
    void getAmountFromPriceButException(int won) {
        Manager manager = new Manager();

        assertThatThrownBy(() -> manager.getAmount(won)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 확인")
    @Test
    void purchaseLotto() {
        Manager manager = new Manager();
        manager.purchaseLotto(5);

        assertThat(manager.getLottoTable().size()).isEqualTo(5);
    }

    @DisplayName("로또 번호 비교하기")
    @ParameterizedTest(name = "{displayName} {0} {1}개 일치")
    @MethodSource("generateData")
    void compareLottoNumbers(List<Integer> numbers, int numberOfMatches) {
        Manager manager = new Manager();
        Lotto purchasedLotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(manager.compareLottoNumbers(purchasedLotto, winningLotto)).isEqualTo(numberOfMatches);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 5),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 0)
        );
    }

    @DisplayName("로또 보너스번호가 있는지 확인.")
    @ParameterizedTest(name = "{displayName} {0}이면 {1}")
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void hasBonusNumber(int bonunsNumber, boolean hasBounsNumber) {
        Manager manager = new Manager();
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean result = manager.hasBonusNumber(purchasedLotto, bonunsNumber);

        assertThat(result).isEqualTo(hasBounsNumber);
    }

    @DisplayName("로또 테이블 비교하기")
    @Test
    void compareLottoTable() {
        Manager manager = new Manager();
        List<Lotto> lottoTable = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 16)),
                new Lotto(List.of(1, 2, 3, 4, 15, 45)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonunsNumber = 45;
        List<Integer> result = manager.compareLottoTable(lottoTable, winningLotto, bonunsNumber);

        assertThat(result).isEqualTo(List.of(6, 15, 5, 4, 3, 0));
    }
}


