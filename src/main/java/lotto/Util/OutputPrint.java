package lotto.Util;

import lotto.domain.Lotto;
import lotto.type.PriceType;
import lotto.type.ResultType;
import lotto.type.TextType;

import java.util.ArrayList;
import java.util.List;

public class OutputPrint {
    public static void moneyToNumberPrint(int number){
        System.out.println(number + "" + TextType.PRICE_TO_NUMBER.getText());
    }

    public static void generatedLottoNumbersPrint(ArrayList<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.print("[");
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.print(numbers.get(i) + ", ");
            }
            System.out.println( numbers.get(numbers.size() - 1) + "]");
        }
    }

    public static void prizePrint(){
        System.out.println(TextType.WINNING_STATISTICS.getText() + "\n" + "---");
    }

    public static void resultPrint(List<Integer> resultList){
        System.out.println(ResultType.MATCH_THREE.getResult() + " " + ResultType.MATCH.getResult() + " " +
                PriceType.FIFTH.getPrice() + " - " + resultList.get(0) + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FOUR.getResult() + " " + ResultType.MATCH.getResult() + " " +
                PriceType.FIFTH.getPrice() + " - " + resultList.get(1) + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FIVE.getResult() + " " + ResultType.MATCH.getResult() + " " +
                PriceType.FIFTH.getPrice() + " - " + resultList.get(2) + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_FIVE.getResult() + " " + ResultType.MATCH.getResult() + " " +
                ResultType.MATCH_BONUS.getResult() + " " + PriceType.FIFTH.getPrice() +
                " - " + resultList.get(2) + ResultType.DIGIT.getResult());
        System.out.println(ResultType.MATCH_SIX.getResult() + " " + ResultType.MATCH.getResult() + " " +
                PriceType.FIFTH.getPrice() + " - " + resultList.get(3) + ResultType.DIGIT.getResult());

    }
}
