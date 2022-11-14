package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    // 구매 티켓만큼 로또번호 생성
    public List<List<Integer>> createRandomNumbers(int ticketCount){
        List<List<Integer>> lottoList =  new ArrayList<>();
        for(int i = 0; i < ticketCount; i++){
            lottoList.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }
        return lottoList;
    }
}