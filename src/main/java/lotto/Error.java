package lotto;

import java.util.List;
import static lotto.UI.*;

public class Error {
    static String number = "1,2,3,4,5,6,7,8,9,0";
    static List<String> Lnumber = List.of(number.split(","));
    public static String Exception_Error(int price){

     if( price/1000 == 0 ){
         Lot_EA = "";
         throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
     }
        return Lot_EA;
    }
    static void number_Error(List<Integer> win_numbers) {
        for (int i = 0; i < win_numbers.size(); i++) {
            if (win_numbers.get(i) > 45 || win_numbers.get(i)<1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    static void EA_ERROR(List<Integer> win_numbers){
        if(win_numbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리를 입력해야 합니다.");
        }
    }
    public static String notNum(String price){
        List<String> Lprice = List.of(price.split(""));
        String Error = "[ERROR] 숫자를체크하시오.";
        for(int i=0; i<Lprice.size(); i++){
            if(!Lnumber.contains(Lprice.get(i))){
                System.out.println(Error);
                throw new IllegalArgumentException(Error);
            }
        }
        return Error;
    }
}
