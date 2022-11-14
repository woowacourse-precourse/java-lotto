package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DrawLottoServiceTest {
    DrawLottoService drawLottoService;

    @BeforeEach
    void beforeEach() {
        drawLottoService = new DrawLottoService();
    }


    @DisplayName("구매한 로또의 갯수를 확인한다.")
    @Test
    void countBuyingLottoTest() {
        //given
        int amount = 10000;
        int expectedCount = 10;

        //when
        int actualCount = drawLottoService.countBuyingLotto(amount);

        //then
        assertThat(expectedCount).isEqualTo(actualCount);
    }

    @DisplayName("입력받은 숫자를 리스트로 변환시켜주는지 확인한다.")
    @Test
    void getListToWiningNumberTest() {
        //given
        String numbers = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> actualNumbers = drawLottoService.getListToWiningNumber(numbers);

        //then
        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("나의 로또와 당첨 로또를 비교하여 잘 저장되는지 확인한다.")
    @ParameterizedTest(name = "{index}등 {8}")
    @CsvSource({"1,2,3,4,5,6,7,4,6개 일치", "1,2,3,4,5,45,6,3,5개일치+보너스일치", "1,2,3,4,5,9,5,2,5개일치", "1,2,3,4,8,9,4,1,4개일치",
            "1,2,3,7,8,9,3,0,3개일치"})
    void compareLottoToWinLottoTest(int num1, int num2, int num3, int num4, int num5, int num6, int rankCount,
                                    int rank, String message) {
        //given
        Lotto myLotto = new Lotto(List.of(num1, num2, num3, num4, num5, num6));
        List<Integer> winLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        Map<Integer, Integer> winingCount = new HashMap<>();
        winingCount.put(rankCount, 1);

        //when
        drawLottoService.compareLottoToWiningLotto(winLotto, myLotto, bonusNumber);
        drawLottoService.setWiningCount();

        //then
        assertThat(winingCount.get(rankCount)).isEqualTo(drawLottoService.getWiningCount().get(rank));
    }
}
