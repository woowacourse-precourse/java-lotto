package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OuputTest {

    OutputView outputView;
    List<Lotto> userlottoGroup;

    @BeforeEach
    void setUP(){
        outputView = new OutputView();
        userlottoGroup = new ArrayList<>();
    }

    @DisplayName("구매한 로또가 형식대로 출력되는지 확인")
    @Test
    void userBuyLottoNumbers(){
        //given
        CreateUserLottoNumbers createUserLottoNumbers = new CreateUserLottoNumbers();
        int amount = 4;
        List<Lotto> given = createUserLottoNumbers.createUserLottoNumber(amount);

        //when
        outputView.printUserBuyLottoNumbers(given);
        //then
        assertThat(given.size()).isEqualTo(4);
    }
}
