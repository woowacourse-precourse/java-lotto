package lotto.domain;


import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomainTest {

    private History history;
    private Lotto lotto;
    private MatchResult matchResult;
    private WinningAmount winningAmount;
    private YieldResult yieldResult;

    @BeforeEach
    public void setUp() {

        history = new History();
        lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        matchResult = new MatchResult();
        winningAmount = new WinningAmount();
        yieldResult = new YieldResult();

    }

    @Test
    public void 로또_생성() throws Exception {
        //given
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);

        //when
        Class<? extends Lotto> lottoClass = lotto.getClass();
        Class<? extends List> integerListClass = integerList.getClass();
        //then
        Assertions.assertEquals(lottoClass, integerListClass);
    }


}