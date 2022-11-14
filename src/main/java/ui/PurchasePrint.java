package ui;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class PurchasePrint {
    public static void intputMoney(){
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void checkPurchase(int count){
        System.out.println(count +"개를 구매했습니다.");
    }
    public static void printLottoNumber(List<Lotto> numbers){
        for(Lotto lotto :numbers){
            Object[] arr = lotto.getNumbers().toArray();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
