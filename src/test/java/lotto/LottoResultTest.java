package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoResultTest {
    List<Lotto> lottoList = new ArrayList<>();
    WinningLottoNumber winningLottoNumber;

    @BeforeEach
    void createInit(){
        lottoList.add(new Lotto("1,2,3,4,5,6"));
        lottoList.add(new Lotto("7,8,9,10,11,12"));
        lottoList.add(new Lotto("13,14,15,16,17,18"));
        winningLottoNumber = new WinningLottoNumber(new Lotto("1,2,3,4,5,6"), new BonusNumber("7"));
    }
    @DisplayName("수익률을 계산한다.")
    @Test
    void getYield() {
        Assertions.assertThat(System.out.printf("%.1f", new LottoResult(lottoList, winningLottoNumber).getYield()))
                .isEqualTo(System.out.printf("%.1f", 666666.66666));
    }
}