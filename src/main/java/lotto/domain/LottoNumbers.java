package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public List<Lotto> printLotto(int total){
        List<Lotto> lotto = new ArrayList<>();
        for(int i=0; i<total; i++){
            Lotto lottoNumber = new Lotto(generateLotto());
            lotto.add(lottoNumber);
        }
        return lotto;
    }
    public List<Integer> generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
        return numbers;
    }

    public void displayLotto(List<Lotto> numbers){
        for(int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i).getLotto());
        }

    }
}
