package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayTest {
    private Player player;

    @BeforeEach
    void beforeEach(){
        player = new Player();
    }


    @ParameterizedTest
    @CsvSource({"5000,5", "6000,6","10000,10","15000,15"})
    void 복권갯수출력(int money, int lottoCount){
        assertThat(player.howManyLotto(money)).isEqualTo(lottoCount);
    }


    @DisplayName("로또 가격이 1000원으로 나눠떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"4500", "12345","5001","12500"})
    void 복권갯수_에러상황(int money){
        assertThatThrownBy(()-> player.howManyLotto(money)).isInstanceOf(IllegalArgumentException.class);
    }


}
