package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public List<Lotto> printLotto(int total){
        List<Lotto> lotto = new ArrayList<>();
        for(int i=0; i<total; i++){
            Lotto lottoNumber = new Lotto(generateLotto());
            lotto.add(lottoNumber);
            System.out.println(i+" " + lotto);
        }
        return lotto;
    }
    public List<Integer> generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLotto(numbers);
    }
    public List<Integer> sortLotto(List<Integer> numbers){
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }
}
