package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoVendor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaTest {
    @DisplayName("immutable 리스트를 이용하여 새로운 arrayList를 만든 후 sort해본다.")
    @Test
    void sortImmutableListValues() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    @DisplayName("Buyer의 getHoldingLottoTickets 리턴값이 immutable한지 확인한다.")
    @Test
    void checkBuyerFunctionReturnImmutableObject() {
        Buyer buyer = new Buyer();
        LottoVendor lottoVendor = new LottoVendor();
        int purchaseMoney = 2000;
        buyer.purchase(lottoVendor, purchaseMoney);

        System.out.println("BEFORE======");
        for (Lotto lotto : buyer.getHoldingLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
        assertThatThrownBy(() -> {
            System.out.println("Modify======");
            buyer.getHoldingLottoTickets().add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        }).isInstanceOf(UnsupportedOperationException.class);

        System.out.println("after======");
        for (Lotto lotto : buyer.getHoldingLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
