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
        return count;
    }




}
