package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoTest {
    private CreateLotto createLotto;

    @DisplayName("발행된 로또가 정렬되어있는지 확인한다.")
    @Test
    void isSorted(){
        createLotto = new CreateLotto();
        assertThat(createLotto.getLotto()).isSorted();
    }
}
