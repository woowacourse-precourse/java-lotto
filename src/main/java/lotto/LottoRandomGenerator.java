package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import static lotto.ValidCheck.validCreateLotto;
import java.util.*;

public class LottoRandomGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;


    public Lotto createLottoNumber(){
        return createLotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_SIZE)));
    }

    private Lotto createLotto(List<Integer> lottoNumbers){
        validCreateLotto(lottoNumbers);
        return new Lotto(lottoNumbers);
    }



}
