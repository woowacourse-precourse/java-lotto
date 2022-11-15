package lotto;

import static lotto.LottoGenerator.generateLottos;
import static lotto.Money.createPurchaseMoney;
import static lotto.constant.Rules.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.BonusNumberDuplicationError;
import lotto.exception.LottoNumberException;
import lotto.exception.MoneyNotDividedByPriceException;
import lotto.exception.MoneyNotPositiveIntegerException;
import lotto.exception.MoneyRangeException;
import lotto.exception.WrongLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(
                List.of(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 5개 이하이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        List<LottoNumber> numbers = convertIntegerListToLottoNumberList(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(WrongLengthException.class);
    }

    @DisplayName("로또 번호가 1이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(LottoNumberException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoNumberException.class);
    }

    @DisplayName("구입 금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyNotDividedByPrice() {
        assertThatThrownBy(() -> createPurchaseMoney("1400"))
                .isInstanceOf(MoneyNotDividedByPriceException.class);
    }

    @DisplayName("구입 금액이 로또 1장 가격보다 작으면 예외가 발생한다.")
    @Test
    void moneyUnderLottoPrice() {
        assertThatThrownBy(() -> createPurchaseMoney("900"))
                .isInstanceOf(MoneyRangeException.class);
    }

    @DisplayName("로또 장수는 구입 금액에서 로또 1장 가격을 나눈 값이다.")
    @Test
    void calculateLottoCount() {
        Money money = createPurchaseMoney(Integer.toString(3 * LOTTO_PRICE));
        assertThat(money.calculateLottoCount()).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복될시 예외가 발생한다.")
    @Test
    void bonusNumberDuplication() {
        List<LottoNumber> winningNumbers = convertIntegerListToLottoNumberList(
                List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(BonusNumberDuplicationError.class);
    }

    @DisplayName("로또 생성 테스트")
    @RepeatedTest(10)
    void generateLotto() {
        generateLottos(10)
                .forEach(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }

    @DisplayName("구입 금액이 양의 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createMoneyNotPositiveInteger() {
        assertThatThrownBy(() -> createPurchaseMoney("-1"))
                .isInstanceOf(MoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("a100"))
                .isInstanceOf(MoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("100a"))
                .isInstanceOf(MoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("0"))
                .isInstanceOf(MoneyNotPositiveIntegerException.class);
        assertThatThrownBy(() -> createPurchaseMoney("abc"))
                .isInstanceOf(MoneyNotPositiveIntegerException.class);
    }

    private List<LottoNumber> convertIntegerListToLottoNumberList(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
