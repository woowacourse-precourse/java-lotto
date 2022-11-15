package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    void evaluate() {

        LottoWinningCreate lottoWinningCreate = new LottoWinningCreate("1,2,3,4,5,6");
        lottoWinningCreate.setBonusNumber("10");
        LottoManager lottoManager = new LottoManager(lottoWinningCreate);
        Lotto lotto = new Lotto(new LottoCreate(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoManager.evaluate(lotto);

        lottoManager.print();
    }
}