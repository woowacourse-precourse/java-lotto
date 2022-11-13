package lotto;

import java.util.List;
import java.util.Scanner;

public class User {
    private int lottoPrice;
    private List<Integer> userNumbers;
    private int bonusNumber;

    public void buyLotto(){
        System.out.println("구매 금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        this.lottoPrice = sc.nextInt();
    }

    public void userNumbers(){

    }

    public void userBonusNumber(){

    }
}
