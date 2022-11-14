package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class User {
    //Enum으로 3,4,5,5+불일치,6 나누기
    private int money;
    private List<Lotto> lottoBag;

    public void getMoneyForLotto() {
        Scanner scanner = new Scanner(System.in);
        money = scanner.nextInt();
    }

    public void buyLotto() {
        Seller seller = new Seller();
        seller.validateMoneyUnit(money);
        lottoBag = seller.sellLotto(money);
    }

    public void printLotto() {
        List<Integer> sortedLotto;
        System.out.println(lottoBag.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBag) {
            sortedLotto = lotto.getNumbers();
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public int compareLotto() {
        Checker checker = new Checker();
        for(Lotto userLotto: lottoBag)
            for(int i = 0; i < userLotto.getNumbers().size(); i++)
                for(int j = 0; j < checker.getWinNumber().size(); j++){
                    if(userLotto.getNumbers().get(i) == checker.getWinNumber().get(j))

                }
    }
}
