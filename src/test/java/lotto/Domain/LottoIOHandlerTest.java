package lotto.Domain;

import lotto.IO.LottoIOHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoIOHandlerTest extends IOTest {
    private static LottoIOHandler lottoIOHandler;
    @BeforeAll
    static void initAll() {lottoIOHandler = new LottoIOHandler();}

    @DisplayName("당첨 번호를 입력 검증")
    @Test
    void getLottoAnswerTest(){
        systemIn("1,2,3,4,5,6");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoIOHandler.getLottoAnswer()).isEqualTo(list);
    }

    @DisplayName("~,~ 형식의 문자열을 리스트로 변환 검증")
    @Test
    void convertStringToIntListTest(){
        assertThat(lottoIOHandler.convertStringToIntList("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }


    @DisplayName("잘못된 당첨 번호 예외처리 검증")
    @Test
    void validateInputTest_notInputComma_IllegalArgumentException(){
        String input = "123456";
        assertThatThrownBy(() -> lottoIOHandler.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] , 구분자를 통해 1~45사이의 수 6개를 입력해주세요");
    }

    @DisplayName("수익률 처리 검증")
    @Test
    void printStatisticsTest(){
        List<Rank> ranks = List.of(Rank.NONE, Rank.NONE, Rank.FIFTH, Rank.NONE);
        assertThat(lottoIOHandler.printStatistics(ranks, 8000)).isEqualTo("62.5");
    }

    @DisplayName("당첨 결과 반환 검증")
    @Test
    void getResultTest(){
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FIRST, Rank.FIFTH, Rank.NONE, Rank.SECOND);
        int[] result = {2, 1, 0, 0, 1};
        assertThat(lottoIOHandler.getResult(ranks)).isEqualTo(result);
    }

}
