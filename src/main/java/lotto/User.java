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

    public List<Lotto> buyLotto(){
        Seller seller = new Seller();
        seller.validateMoneyUnit(money);
        lottoBag = seller.sellLotto(money);
    }
}
