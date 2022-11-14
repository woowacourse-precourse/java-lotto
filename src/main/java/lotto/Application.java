package lotto;

import lotto.domain.LottoGenerator;

import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        int purchaseNumber = LottoGenerator.inputMoney();
        List list = LottoGenerator.finalGenerator(purchaseNumber);
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        // TODO: 프로그램 구현
    }
}
