package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.util.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGenerator {

    public static int inputMoney(){
        int purchaseNumber = 0;
        Message.requestPurchase();
        int inputMoney = Integer.parseInt(readLine());
        purchaseNumber = inputMoney/1000;

        return purchaseNumber;
    }

    public static List<Integer> numberGenerator(){
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(numbers);

        return numbers;
    }

    public static List<List<Integer>> finalGenerator(int purchaseNumber){
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i=0;i<purchaseNumber;i++){
            numbers.add(numberGenerator());
        }
        return numbers;
    }
}
