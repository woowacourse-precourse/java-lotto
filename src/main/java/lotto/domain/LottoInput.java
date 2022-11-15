package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoInput {

    public int parseStringToInt(String number){
        return Integer.parseInt(number);
    }

    public int lottoCount(String StringMoney){    // 로또 개수
        int money = parseStringToInt(StringMoney);
        int count = money/1000;
        // validation 처리 나중에
        return count;
    }



    public List<Integer> stringToListIntegar(String winningNumber){
        List<String> winningList = Arrays.asList(winningNumber.split(","));
        List<Integer> winningNumberList = new ArrayList<>();

        for (int i = 0; i < winningList.size(); i++){
            winningNumberList.add(parseStringToInt(winningList.get(i)));
        }
        return winningNumberList;
    }



}
