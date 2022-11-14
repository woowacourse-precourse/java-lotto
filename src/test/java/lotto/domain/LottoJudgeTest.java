package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import lotto.domain.vo.BuyLottoList;
import lotto.domain.vo.Lotto;
import lotto.domain.vo.LottoWithBonus;
import lotto.veiw.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoJudgeTest {

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    LottoWithBonus lottoWithBonus = new LottoWithBonus(lotto, 7);

    @DisplayName("Normal Result Test")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @CsvSource(value = {"SIX:1,2,3,4,5,6", "BONUS:1,2,3,4,5,7", "FIVE:1,2,3,4,5,8",
            "FOUR:1,2,3,4,8,7", "THREE:1,2,3,9,8,7", "NOPE:1,2,10,9,8,7"}, delimiter = ':')
    void Calculate_Result_Test(String result, String inputString) {
        InputHandler inputHandler = new InputHandler();
        List<Lotto> buyList = Collections.singletonList(
                new Lotto(inputHandler.stringToList(inputString)));
        BuyLottoList buyLottoList = new BuyLottoList(buyList);

        LottoJudge lottoJudge = new LottoJudge(buyLottoList, lottoWithBonus);
        System.out.println(lottoJudge.getValue());
        assertThat(lottoJudge.getValue().toString()).isEqualTo("{" + result + "=1}");
    }
}