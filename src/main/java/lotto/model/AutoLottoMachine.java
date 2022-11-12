package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class AutoLottoMachine implements LottoMachine{

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int COUNT = 6;

    public Lotto generateLottoTicket(){
        List<Integer> lottoNumber = pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);

        return new Lotto(lottoNumber);
    }

}
