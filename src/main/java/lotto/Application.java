package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int Number_Of_Purchases;
        List<List<Integer>> LottoNumbers;

        Number_Of_Purchases = purchaseLotto();
        System.out.println();
        System.out.println(Number_Of_Purchases+"개를 구매했습니다.");

        LottoNumbers = createLottoNumber(Number_Of_Purchases);

        printLottoNumber(LottoNumbers);

    }
    public static int purchaseLotto(){
        int cost;

        System.out.println("구입금액을 입력해 주세요.");
        try{
            cost = Integer.parseInt(Console.readLine());
        }
        catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력하세요.");
        }
        if (cost % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위에 금액을 입력하세요.");
        }
        return cost/1000;
    }

    public static List<List<Integer>> createLottoNumber(int Number_Of_Purchases){
        List<List<Integer>> LottoNumbers = new ArrayList<>();
        while(Number_Of_Purchases>0){
            LottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Number_Of_Purchases--;
        }
        return LottoNumbers;
    }

    public static void printLottoNumber(List<List<Integer>> LottoNumbers){
        for (List<Integer> lottoNumber : LottoNumbers) {
            System.out.println(Arrays.toString(lottoNumber.stream().sorted().toArray()));
        }
    }

}
