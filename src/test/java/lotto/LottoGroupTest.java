package lotto;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    private LottoGroup lottoGroup;

    @BeforeEach
    void setUp() {
        lottoGroup = new LottoGroup();
    }

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void createLottoTest() {
        //Lotto객체 자체가 1급 컬렉션으로써 예외들을 다 잡아주기 때문에 개수가 늘어나는지 테스트만 하면 된다.
        lottoGroup.createLotto();
        lottoGroup.createLotto();

        assertThat(lottoGroup.getAllLotteryTickets().size()).isEqualTo(2);
    }
}
