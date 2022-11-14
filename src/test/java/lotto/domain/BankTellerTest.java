package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class BankTellerTest extends NsTest {
    @Test
    void test() {
        assertRandomUniqueNumbersInRangeTest(
                ()->run("8000","1,2,3,4,5,6","7"),
                List.of(1,2,3,4,5,6),
                List.of(1, 2, 3, 4, 5, 7),   // 2등
                List.of(1, 2, 3, 4, 5, 12), // 3등
                List.of(1, 2, 3, 4, 12, 13),    // 4등
                List.of(1, 2, 3, 12, 13, 14),   // 5등
                List.of(1, 2, 11, 12, 13, 14),   // 꽝
                List.of(1, 15, 11, 12, 13, 14),   // 꽝
                List.of(16, 15, 11, 12, 13, 14));
        assertThat(output()).contains(
                "당첨 통계\n---",
                "2개 이하 일치 (0원) - 3개",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 25394437.5%입니다."
                );
    }

    @Override
    protected void runMain() {
        PrizeCalculator calculator = new PrizeCalculator();
        LottoReader lottoReader = new LottoReader();
        BankTeller bankTeller = new BankTeller(calculator, lottoReader);
        LottoCompany lottoCompany = new LottoCompany();

        Customer customer = new Customer(new Bag());
        LottoStore lottoStore = new LottoStore(new LottoStoreClerk(new LottoPrinter()));

        lottoStore.sellLotto(customer);
        lottoCompany.draw();

        bankTeller.givePrizeTo(customer, lottoCompany);
    }
}