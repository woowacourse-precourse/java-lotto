package lotto;

import java.util.List;
import java.util.Scanner;

public class User {
    private int money;
    private List<Lotto> lottoBag;

    public void getMoneyForLotto(){
        Scanner scanner = new Scanner(System.in);
        money = scanner.nextInt();
    }

    public void buyLotto(){
        Seller seller = new Seller();
        seller.validateMoneyUnit(money);
        lottoBag = seller.sellLotto(money);
    }

    public void printLotto(){
        System.out.println(lottoBag.size() + "개를 구매했습니다.");
        for(Lotto lotto: lottoBag){
            System.out.println(lotto);
        }
    }

    public void compareLotto(){

    }
}
