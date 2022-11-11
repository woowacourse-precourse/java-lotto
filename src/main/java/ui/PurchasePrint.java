package ui;
import lotto.Lotto;
import java.util.List;
import java.util.SimpleTimeZone;

public class PurchasePrint {
    public static void intputMoney(){
        System.out.println("구입금액을 입력해 주세요");
    }
    public static void checkPurchase(int count){
        System.out.println(count +"개를 구매했습니다.");
    }
    public static String printLottoNumber(List<Lotto> numbers){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.size(); i++) {
            sb.append(numbers.get(i).toString());
            if(i!=numbers.size()-1)
            sb.append("\n");
        }
       return sb.toString();
    }
}
