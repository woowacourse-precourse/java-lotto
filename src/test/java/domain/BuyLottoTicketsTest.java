package domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

class BuyLottoTicketsTest {


    @Test
    @DisplayName("자동추출한 로또 티켓이 제대로 값이 들어갔는지 확인!")
    void setLottoNumberTicket() {
        List<Integer> LottoTicket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(LottoTicket);
        Assertions.assertThat(LottoTicket.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("자동추출한 로또 티켓이 제대로 값이 들어갔는지 확인!")
    void setLottoNumberTicket_isSort() {
        List<Integer> LottoTicket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(LottoTicket);
        Assertions.assertThat(isSorted(LottoTicket)).isEqualTo(true);
    }


    boolean isSorted(List<Integer> LottoTicket) {

        for (int index = 0; index < LottoTicket.size() - 1; index++) {
            if (LottoTicket.get(index) > LottoTicket.get(index + 1)) {
                return false;
            }
        }
        return true;
    }


}