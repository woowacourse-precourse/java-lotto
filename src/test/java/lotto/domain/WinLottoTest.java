package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {
    @Test
    public void winLottoCreateTest() throws Exception{
        Lotto lotto = new Lotto(List.of(12,3,4,5,6,7));
        WinLotto winLotto = new WinLotto(lotto,1);
        Assertions.assertEquals(winLotto.getWinNumbers(),List.of(12,3,4,5,6,7,1));
    }

}