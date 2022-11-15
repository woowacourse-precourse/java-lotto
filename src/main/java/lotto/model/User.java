package lotto.model;
import camp.nextstep.edu.missionutils.Console;
public class User {
    public void getBudget(){
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());
        if(budget%1000!=0){
            throw new IllegalArgumentException("구입금액은 1000원 단위입니다!");
        }

    }

}
