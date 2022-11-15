package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.ErrorMessage.*;

public class LottoGenerator {

    public static int originInputMoney;
    public static int inputMoney(){
        int purchaseNumber = 0;
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(Console.readLine());
        originInputMoney = inputMoney;
        if (inputMoney == 0 || inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR_MESSAGE.getMessage());
        }
        purchaseNumber = inputMoney/1000;

        return purchaseNumber;
    }

    public static List<Integer> numberGenerator(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);

        return numbers;
    }

    public static List<Lotto> finalGenerator(int purchaseNumber){
        List<Lotto> numbers = new ArrayList<>();
        System.out.println();
        System.out.println(purchaseNumber + "개를 구매했습니다.");
        for(int i=0;i<purchaseNumber;i++){
            List<Integer> tmp = numberGenerator();
            System.out.println(tmp);
            numbers.add(new Lotto(tmp));

        }
        return numbers;
    }

}

