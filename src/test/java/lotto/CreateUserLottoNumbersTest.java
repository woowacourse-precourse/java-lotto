package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserLottoNumbersTest {
    CreateUserLottoNumbers createUserLottoNumbers;

    @BeforeEach
    void setUp(){
        createUserLottoNumbers = new CreateUserLottoNumbers();
    }

    @DisplayName("로또 구매 개수대로 로또가 생성되는지 확인")
    @Test
    void randomLottoNumbers(){
        //given
        int amount = 4;

        //when
        List<List<Integer>> actual = createUserLottoNumbers.randomLottoNumbers(amount);

        //then
        assertThat(actual.size()).isEqualTo(4);
    }
}
