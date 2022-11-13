package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private static final int CNT_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private List<List> userLotto = new ArrayList<>();

    public UserLotto() {}

    public int setPurchaseAmount(){
        int input = Integer.parseInt(Console.readLine());
        return input;
    }

    public void getPurchaseLottoNumbers(){
        for(int i=0;i<userLotto.size();i++){
            List<Integer> numbers = new ArrayList<>(userLotto.get(i));
        }
    }

    public void validateUnit(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
        }
    }

    public void setRandomNumber(){
        List<Integer> lottoNumbers = new ArrayList<>();

        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,CNT_NUMBER);
        Collections.sort(lottoNumbers);

        new Lotto(lottoNumbers);

        userLotto.add(lottoNumbers);
    }

}
