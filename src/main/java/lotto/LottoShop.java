package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoShop {
    LottoConsole lottoConsole = new LottoConsole();

    public int buyLotto(){
        return checkMoney(lottoConsole.inputMoney());
    }

    public List<Lotto> generateLottoList(int money) {
        int numberOfLotto = money/1000;
        List<Lotto> lottoList = new ArrayList<>();
        while(numberOfLotto!=0){
            lottoList.add(generateLotto());
            --numberOfLotto;
        }
        lottoConsole.outputLottoList(lottoList);
        return lottoList;
    }

    private Lotto generateLotto(){
        return new Lotto(sortLottoByAsc(generateRandomNumbers()));
    }

    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortLottoByAsc(List<Integer> randomList){
        Collections.sort(randomList);
        return randomList;
    }

    private int checkMoney(String inputMoney){
        int money = changeStringToInteger(inputMoney);
        if((money%1000) != 0){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 1000원 단위가 아닙니다.");
        }
        return money;
    }

    private int changeStringToInteger(String str1){
        try {
            int int1 = Integer.parseInt(str1);
            return int1;
        } catch(NumberFormatException exception){
            throw new NumberFormatException("[ERROR] 입력된 값이 숫자가 아닙니다.");
        }
    }
}