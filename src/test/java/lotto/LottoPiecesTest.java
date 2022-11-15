package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoPieces;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPiecesTest {

    @DisplayName("10000원 구매 시 10장을 구매한다")
    @Test
    void get10PiecesWhenPay10000(){
        int pieces = LottoPieces.calculatePieces(new Money(10000));
        assertThat(pieces).isEqualTo(10);
    }
}
