package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.CommonContent.PrintLottoContent.PURCHASEAMOUNT;

public class Application {

    private static Integer purchaseNumbers;

    public static void main(String[] args) {
        byeLotto();
    }

    public static void byeLotto(){
        try{
            System.out.println(PURCHASEAMOUNT.getPrintStatement());
            purchaseNumbers = Integer.parseInt(readLine())/1000;

            if(purchaseNumbers == 0){
                throw new IllegalArgumentException();
            }
            System.out.println(CommonContent.PrintLottoContent.purchaseNumbers(purchaseNumbers));
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }





}
