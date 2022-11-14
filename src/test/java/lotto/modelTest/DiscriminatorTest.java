package lotto.modelTest;

import lotto.model.Discriminator;
import lotto.model.Lotto;
import lotto.model.Lottery;
import lotto.model.RaffleNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminatorTest {
    @Test
    @DisplayName("발행한 로또 번호와 입력받은 추첨 번호를 이용하여 몇 개를 맞췄는지 확인한다.")
    public void guessLottoNumber(){
        int expectedResult = 5;
        List<Integer> lottoNumbers=List.of(1,45,6,7,8,20);
        Lotto lotto = new Lotto(lottoNumbers);
        String raffleNumbers="1,45,6,7,9,20";
        String bonusNumber="8";
        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);
        Discriminator discriminator = new Discriminator(raffleNumber);
        assertThat(discriminator.guessLottoNumber(lotto)).isEqualTo(expectedResult);
    }
    @Test
    @DisplayName("추첨 번호를 5개 맞추었다면 true를 반환")
    public void checkThatLottoMatchesFiveOfRaffleNumber(){
        String raffleNumbers="1,45,6,7,9,20";
        String bonusNumber="8";
        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);
        Discriminator discriminator = new Discriminator(raffleNumber);
        assertThat(discriminator.canSecondRank(5)).isTrue();
    }
    @ParameterizedTest
    @DisplayName("추첨 번호를 5개 이상 또는 이하로 맞추었다면 false를 반환")
    @ValueSource(ints={1,2,3,4,6})
    public void checkThatLottoDoesNotMatchesFiveOfRaffleNumber(int matchCount){
        String raffleNumbers="1,45,6,7,9,20";
        String bonusNumber="8";
        RaffleNumber raffleNumber = new RaffleNumber(raffleNumbers, bonusNumber);
        Discriminator discriminator = new Discriminator(raffleNumber);
        assertThat(discriminator.canSecondRank(matchCount)).isFalse();
    }

}
