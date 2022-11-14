package lotto.domain.seller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRanking;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SellerTest {

    @DisplayName("[성공] 구입 금액을 통해서 로또를 몇 장 구매할 수 있는지 찾기")
    @Test
    void findLottoCountByMoney() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        int money = 10000;
        int lottoCount = seller.findLottoCountByMoney(money);
        assertThat(lottoCount).isEqualTo(10);
    }

    @DisplayName("[예외 발생] 로또 금액이 1000원으로 나누어 떨어지지 않는다면 IllegalException 발생")
    @Test
    void findLottoCountByMoneyOfDivide1000() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        int money = 10001;
        assertThatThrownBy(() -> seller.findLottoCountByMoney(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[성공] 로또 당첨 번호와 구매한 로또 번호를 비교하여 당첨 번호에 포함되는 개수 찾기")
    @Test
    void compareNumbers() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(seller.compareNumbers(numbers)).isEqualTo(5);
    }

    @DisplayName("[성공] 로또 당첨 보너스 번호와 구매한 로또 번호를 비교하여 보너스 번호가 포함되어 있는지 확인")
    @Test
    void compareBonusNumber() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        assertThat(seller.compareBonusNumber(numbers)).isTrue();
    }

    @DisplayName("[성공] 로또 당첨 몇등인지 확인하기 - 1등")
    @Test
    void findLottoRanking_First() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        LottoRanking lottoRanking = seller.findLottoRanking(new LottoCount(6, false));
        assertThat(lottoRanking).isEqualTo(LottoRanking.FIRST);
    }

    @DisplayName("[성공] 로또 당첨 몇등인지 확인하기 - 2등")
    @Test
    void findLottoRanking_Second() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        LottoRanking lottoRanking = seller.findLottoRanking(new LottoCount(5, true));
        assertThat(lottoRanking).isEqualTo(LottoRanking.SECOND);
    }

    @DisplayName("[성공] 로또 당첨 몇등인지 확인하기 - 3등")
    @Test
    void findLottoRanking_Third() {
        Seller seller = new LottoMachine(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));
        LottoRanking lottoRanking = seller.findLottoRanking(new LottoCount(5, false));
        assertThat(lottoRanking).isEqualTo(LottoRanking.THIRD);
    }

}
