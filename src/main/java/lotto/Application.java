package lotto;

import lotto.Money;
import lotto.Lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        int count = Money.calcmoney();
        System.out.println(count + "개를 구매했습니다.");
        for(int i=0 ; i<count ; i++){
            Lotto lotto = new Lotto(new ArrayList<>());
        }
    }
}
