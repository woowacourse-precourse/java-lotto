package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class LottoTest {
    /*@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    /*@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    @DisplayName("로또 번호 string으로 받은 것 List에 넣기")
    @Test
    void changeStringToList() {

        Maker changeStringToList = new Maker();

        assertEquals(changeStringToList.lottoWinList("1,2,3,4,5,6"), List.of(1,2,3,4,5,6));
    }


    @DisplayName("6개의 로또 번호를 생성해주는지")
    @Test
    void randomLottoNumberGeneration(){

        Generator generator = new Generator();

        assertEquals(generator.generateRandomLottoNumber().size(),6);

    }



}
