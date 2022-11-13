package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    @DisplayName("구입 금액에 따라 로또를 생성한다.")
    @Test
    void createMyLotto() {
        MyLotto myLotto = new MyLotto(8);
        assertThat(myLotto.getMyLotto().size()).isEqualTo(8);
    }

    @DisplayName("구입 금액에 따라 로또를 확인한다.")
    @Test
    void checkMyLottoResult() {
        MyLotto myLotto = new MyLotto(1000);
        Lotto winNumber = new Lotto(List.of(11,21,34,45,25,36));
        BonusNumber bonusNumber = new BonusNumber("7", winNumber);

        myLotto.checkEachLotto(winNumber, bonusNumber);


        for (Rank rank : Rank.values()) {
            System.out.println(rank.name() +" : "+myLotto.getEachLottoRank().get(rank.name()));
        }
    }
}
