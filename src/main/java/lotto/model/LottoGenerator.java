package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.ArrayList;

public class LottoGenerator {

    public List<Lotto> createLottoNumbers(int lottoAmount){
         List<Lotto> lottos = new ArrayList<>();

         while(lottoAmount>0) {
             List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
             Lotto lotto = new Lotto(numbers);
             lottos.add(lotto);
             lottoAmount--;
         }

        return lottos;

    }


}
