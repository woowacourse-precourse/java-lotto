package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    @DisplayName("구입 금액에 따른 개수만큼 로또 번호를 랜덤 생성한다.")
    @Test
    void createRandomLottoBasedOnPurchasePrice(){
        Integer money = 8000;
        Buyer buyer = new Buyer(money);
        NumberGenerator lottogenerator = new NumberGenerator();
        Integer NumberOfLotto = buyer.getNumOfLotto();
        LottoGroup lottoGroup = new LottoGroup(lottogenerator.generateLotto(NumberOfLotto));
        assertThat(lottoGroup.getLottoGroup().size()).isEqualTo(8);
    }
}
