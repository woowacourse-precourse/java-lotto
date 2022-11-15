package lotto.ui;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.ui.OutputMessageGenerator.*;

public class OutputMessageGeneratorTest {
    @DisplayName("`[구매 수량]개를 구매했습니다.` 를 반환한다.")
    @Test
    void getPurchaseLottoMessageTest() {
        assertThat(getPurchaseLottoMessage(4))
                .isEqualTo("4개를 구매했습니다.");
    }

    @DisplayName("오름차순으로 정렬한 로또 번호를 문자열로 반환한다.")
    @Test
    void getAllLottoNumbersByAscendingOrderTest() {
        List<Lotto> lotteries = List.of(new Lotto(List.of(1, 4, 5, 6, 2, 3)));
        assertThat(getAllLottoNumbersByAscendingOrder(lotteries))
                .isEqualTo(List.of("[1, 2, 3, 4, 5, 6]"));
    }
}
