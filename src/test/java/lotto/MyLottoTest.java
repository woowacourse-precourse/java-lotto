package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    public static MyLotto myLotto;

    @BeforeAll
    static void setMyLotto() {
        try {
            myLotto = new MyLotto(new Purchase("8000"));
        } catch (Exception e) {
        }
    }

    @DisplayName("구입 금액에 따라 로또를 생성한다.")
    @Test
    void createMyLotto() {
        assertThat(myLotto.getMyLotto().size()).isEqualTo(8);
    }

    @DisplayName("구입 금액에 따라 로또를 확인한다.")
    @Test
    void checkMyLottoResult() {
        WinNumber winNumber = null;
        BonusNumber bonusNumber = null;
        try {
            winNumber = new WinNumber("11,21,34,45,25,36");
            bonusNumber = new BonusNumber("7", winNumber);
        } catch (Exception e) {
        }

        myLotto.checkEachLotto(winNumber, bonusNumber);


        for (Rank rank : Rank.values()) {
            System.out.println(rank.name() + " : " + myLotto.getEachLottoRank().get(rank.name()));
        }
    }
}
