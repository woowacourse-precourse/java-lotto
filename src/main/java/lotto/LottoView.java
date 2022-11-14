package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.*;

public class LottoView {
    public static int inputMoney(){

        System.out.println("구입금액을 입력해 주세요.");
        return convertInputToInt(Console.readLine());
    }
    public static void printNumber_of_Purchase(int Number_of_Purchase){
        System.out.println();
        System.out.println(Number_of_Purchase+"개를 구매했습니다.");
    }
    public static void printLottos(List<Lotto> lottos){
        for (Lotto lotto : lottos){
            System.out.println(Arrays.toString(lotto.getNumbers().stream().sorted().toArray()));
        }
    }
    public static void printInputWinningNumber(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printInputBonusNumber(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    private static int convertInputToInt(String input){
        try{
            return Integer.parseInt(input);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력하세요.");
        }
    }

    public static void printWinningResult(HashMap<Rank,Integer> result){
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Rank, Integer> entry: result.entrySet()){
            if(!entry.getKey().equals(Rank.FAIL)){
                System.out.println(entry.getKey().getMatchCount()+"개 일치 (" + formatter.format(entry.getKey().getPrize()) + "원) - "+entry.getValue()+"개");
            }
        }
    }
    public static void printProfitResult(double profit){
        System.out.println("총 수익률은 "+ String.format("%.1f",profit) +"%입니다.");
    }
}
