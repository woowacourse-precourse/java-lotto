package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Integer> createLottoNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public List<Lotto> createTotalLottoNumber(int lottoCount){
        List<Lotto> totalLottoNumbers = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++){
            totalLottoNumbers.add(new Lotto(createLottoNumber()));
        }
        return totalLottoNumbers;
    }
}
