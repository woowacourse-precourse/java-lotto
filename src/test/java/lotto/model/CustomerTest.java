package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    LottoCompany lottoCompany = makeLottoCompany("1,2,3,4,5,6", "7");

    @DisplayName("구매 금액 5000을 입력하면 소비자는 5000원을 가지고 있어야 한다.")
    @Test
    void getPurchasePriceTest() {
        Customer customer = new Customer(new PurchasePrice("5000"));
        assertThat(customer.getPurchasePrice().getPurchasePrice()).isEqualTo(5000);
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림되야 한다.")
    @Test
    void buyTest() {
        Customer customer = new Customer(new PurchasePrice("3000"));
        customer.buy(List.of(makeLotto(1, 2, 3, 8, 9, 10),
                makeLotto(1, 7, 9, 10, 11, 12),
                makeLotto(1, 2, 3, 4, 5, 7)));
        MatchResult matchResult = customer.checkMyLottoNumbers(lottoCompany);

        assertThat(matchResult.getResultByMatchType(MatchType.THREE)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.FOUR)).isEqualTo(0);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE)).isEqualTo(0);
        assertThat(matchResult.getResultByMatchType(MatchType.FIVE_BONUS)).isEqualTo(1);
        assertThat(matchResult.getResultByMatchType(MatchType.SIX)).isEqualTo(0);
        assertThat(matchResult.getTotalPrizeMoney())
                .isEqualTo(MatchType.THREE.getPrizeMoney() + MatchType.FIVE_BONUS.getPrizeMoney());
        assertThat(String.format("%.1f", customer.calculateProfit(matchResult))).isEqualTo("1000166.7");
    }

    private LottoCompany makeLottoCompany(String winningLottoInput, String bonusNumberInput) {
        Lotto winningLotto = new WinningLotto(winningLottoInput).toLotto();
        LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
        return new LottoCompany(winningLotto, bonusNumber);
    }

    private Lotto makeLotto(int... numbers) {
        return new Lotto(Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet()));
    }
}