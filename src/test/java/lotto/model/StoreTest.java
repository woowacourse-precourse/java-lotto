package lotto.model;

import static lotto.model.Rank.FIFTH_PLACE;
import static lotto.model.Rank.FIRST_PLACE;
import static lotto.model.Rank.FOURTH_PLACE;
import static lotto.model.Rank.SECOND_PLACE;
import static lotto.model.Rank.THIRD_PLACE;
import static lotto.utils.NumberAdapter.fitPaidMoney;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StoreTest {
    private Store testStore;
    private String paidMoney;

    @BeforeEach
    void setUp() {
        testStore = new Store();
    }

    void setCustomerForStore() {
        String beforePaidMoney = "3000";
        paidMoney = beforePaidMoney;

        testStore.sellLottoToCustomer(paidMoney);
    }

    void setWinningNumberWithBonusNumber() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        testStore.pickWinningNumberWithBonusNumber(winningNumber, bonusNumber);
    }

    @Test
    @DisplayName("로또를 파는 메서드가 새로운 Customer 객체를 생성한다.")
    void checkSellLottoToCustomerCreateNewCustomer() {
        //given
        String paidMoney = "3000";

        //when, then
        assertThatNoException().isThrownBy(() -> testStore.sellLottoToCustomer(paidMoney));
    }

    @Test
    @DisplayName("유효한 당첨번호와 보너스 번호를 입력받고 유효성 검사를 통과한다.")
    void checkPickWinningNumberWithBonusNumberByValidInput() {
        //given
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when, then
        assertThatNoException().isThrownBy(
                () -> testStore.pickWinningNumberWithBonusNumber(winningNumber, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호를 통해 고객의 당첨 현황을 반환한다.")
    void checkJudgeCustomerRanks() {
        //given
        setCustomerForStore();
        setWinningNumberWithBonusNumber();
        int paidMoneyToInteger = fitPaidMoney(paidMoney);

        //when
        Map<Rank, Integer> ranks = testStore.judgeCustomerRanks();
        Set<Rank> rankKeys = ranks.keySet();
        Set<Rank> compareRankKeys = Set.of(
                FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE);

        //then
        assertThat(rankKeys).isEqualTo(compareRankKeys);
    }

    @Test
    @DisplayName("고객이 갖고 있는 모든 로또들을 오름차순으로 정렬하여 문자열로 반환한다.")
    void checkFindAllLottoByCustomer() {
        //given
        setCustomerForStore();

        //when
        String answer = testStore.getAllLottoByCustomer();

        //then
        assertThat(answer).contains("[");
    }
}
