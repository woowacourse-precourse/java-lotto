package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {


    @DisplayName("구입한 로또 개수 확인")
    @Test
    void countBoughtLotto(){
        int result = new Money(18000L).countBoughtLotto();
        assertEquals(18, result);
    }


}
