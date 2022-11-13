package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LotteryScratchTest {

    @Test
    @DisplayName("1등 당첨")
    public void rank1Test() {
        String lottoNumbers = "1,2,3,4,5,6";
        String bonusNumbers = "7";
        WinningNumber winningNumber = new WinningNumber(lottoNumbers, bonusNumbers);
        // 랜덤으로 생성되는 Lotto에 대해서 1,2,3,4,5,6으로 생성되엇을때 일치하는지 확인
    }

}