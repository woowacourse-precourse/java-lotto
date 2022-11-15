package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Utils.string2int;


public class Application {

    public static void main(String[] args) {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            int purchase = string2int(readLine());

            Buyer buyer = new Buyer(purchase);


        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
