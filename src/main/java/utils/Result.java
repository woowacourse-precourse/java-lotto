package utils;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    // 로또 번호 List 오름차순으로 정렬
    public List<Integer> sortLottoNumbers(List<Integer> lottoNumbers){
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    // 로또 번호 List를 Lotto객체로 변환
    public Lotto listToLottoObject(List<Integer> lottoNumbers){
        Lotto lotto = new Lotto(lottoNumbers);

        return lotto;
    }


}
