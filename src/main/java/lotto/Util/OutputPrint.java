package lotto.Util;

import lotto.domain.Lotto;
import lotto.type.TextType;

import java.util.ArrayList;
import java.util.List;

public class OutputPrint {
    public static void moneyToNumberPrint(int number){
        System.out.println(number + "" + TextType.PRICE_TO_NUMBER);
    }

    public static void generatedLottoNumbersPrint(ArrayList<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.print("[");
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.println(numbers.get(i) + ", ");
            }
            System.out.println("]");
        }
    }
}
