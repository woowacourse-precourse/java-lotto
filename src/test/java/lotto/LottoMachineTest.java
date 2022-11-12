package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import lotto.Lotto;
import lotto.LottoMachine;

import java.util.Iterator;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("복권을 구매합니다.")
    @Test
    void 복권_구매_테스트(){
        List<Lotto> lottos = new ArrayList<>();

        LottoMachine.buyLotto(lottos, BigInteger.valueOf(8000));

        Iterator<Lotto>iter = lottos.iterator();
        while (iter.hasNext()){
            Lotto lotto = iter.next();
            System.out.println(lotto);
        }
    }

    @DisplayName("구매해간 복권을 모두 출력합니다.")
    @Test
    void 복권_구매_리스트_테스트(){
        List<Lotto> lottos = new ArrayList<>();
        LottoMachine.buyLotto(lottos, BigInteger.valueOf(8000));
        LottoMachine.printLottoLog(lottos);
    }
}