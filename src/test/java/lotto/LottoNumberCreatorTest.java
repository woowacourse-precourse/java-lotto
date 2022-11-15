package lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LottoNumberCreatorTest {
    @DisplayName("사용자가 입력한 구매 금액에 따라 수량이 생성되는지")
    @Test
    void checkLottoTicketQuantity() {
        LottoNumberCreator creator = new LottoNumberCreator(5000);

        assertThat(creator.getNumbersContainer().size() == 5);
    }
}
