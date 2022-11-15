package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoInput {

    public int parseStringToInt(String money){
        return Integer.parseInt(money);
    }

    public int lottoCount(String StringMoney){    // 로또 개수
        int money = parseStringToInt(StringMoney);
        int count = money/1000;
        // validation 처리 나중에
        System.out.println(count);
        return count;
    }



    public List<Integer> lottoRandom(int count) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println("랜덤:"+numbers);
        return numbers;

    }
}
