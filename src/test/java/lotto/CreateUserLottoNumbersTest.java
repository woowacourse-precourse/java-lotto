package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserLottoNumbersTest {
    CreateUserLottoNumbers createUserLottoNumbers;
    List<Lotto> lottos;

    @BeforeEach
    void setUp(){
        createUserLottoNumbers = new CreateUserLottoNumbers();
        lottos = new ArrayList<>();
    }

    @DisplayName("생성된 로또 번호의 개수 확인")
    @Test
    void createUserLottoNumber(){
        //given
        int amount = 1;
        //when
        List<Lotto> actual = createUserLottoNumbers.createUserLottoNumber(amount);
        //then
        assertThat(actual.get(0).getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("구매 개수 만큼 로또 번호가 생성되는지 확인")
    @Test
    void createUserMultipleLottoNumber(){
        //given
        int amount = 4;
        //when
        List<Lotto> actual = createUserLottoNumbers.createUserLottoNumber(amount);
        //then
        assertThat(actual.size()).isEqualTo(4);
    }
}
