package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Utils.string2int;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try{

            System.out.println("구입금액을 입력해 주세요.");
            int purchased = string2int(readLine());
            System.out.println(purchased+"");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }



    }
}
