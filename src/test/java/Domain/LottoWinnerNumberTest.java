package Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumberTest {

    @Test
    @DisplayName("입력받은 문자열 당첨 번호는 리스트로 변환된다.")
    void convertWinnerNumber() {
        //given
        String winnerLottoNumber = "1,3,5,7,9,11";
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerLottoNumber);
        List<Integer> expectLottoNumber = new ArrayList<>(Arrays.asList(1,3,5,7,9,11));

        //when
        List<Integer> convertLottoNumber = lottoWinnerNumber.convertWinnerNumber(winnerLottoNumber);

        //then
        assertEquals(convertLottoNumber,expectLottoNumber);
    }

}
