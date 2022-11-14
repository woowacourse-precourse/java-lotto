package lotto.modelTest;

import lotto.model.Discriminator;
import lotto.model.Lotto;
import lotto.model.Lottery;
import lotto.model.RaffleNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminatorTest {
    @Test
    @DisplayName("발행한 로또 번호와 입력받은 추첨 번호를 이용하여 몇 개를 맞췄는지 확인한다.")
    public void guessLottoNumberTest(){
        int expectedResult = 5;
        List<Integer> lottoNumbers=List.of(1,45,6,7,8,20);
        Lotto lotto = new Lotto(lottoNumbers);
        String raffleNumbers="1,45,6,7,9,20";
        String bonusNumber="8";
        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);
        Discriminator discriminator = new Discriminator(raffleNumber);
        assertThat(discriminator.guessLottoNumber(lotto)).isEqualTo(expectedResult);
    }
}
