package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class LottoSeller {
    private final int money;
    private final int piece;
    private List<Lotto> bundle = new ArrayList<Lotto>();

   LottoSeller() {
       String moneyBeforeValidation;

       System.out.println("구입금액을 입력해 주세요.");
       moneyBeforeValidation = Console.readLine();
       validateMoney(moneyBeforeValidation);
       this.money = Integer.parseInt(moneyBeforeValidation);
       this.piece = money/1000;
    }

    LottoSeller(int money) {
        this.money = money;
        this.piece = money/1000;
    }

    LottoSeller(List<Lotto> bundle) {
        this.bundle = bundle;
        money = 0;
        piece = 0;
    }

    void makeLottoBundle() {
        for (int count = 1; count <= piece; count++) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumber);

            bundle.add(lotto);
        }
    }

    void printBundle() {
        System.out.println(piece + "개를 구매했습니다.");
        for (int index = 0; index < bundle.size(); index++) {
            List<Lotto> bundleCopied = new ArrayList<>(bundle);

            bundleCopied.get(index).print();;
        }
    }

    List<Lotto> getBundle() {
        return this.bundle;
    }

    int getMoney() {
       return this.money;
    }

    int getPiece() {
        return this.piece;
    }

    private void validateMoney(String money) {
       for (int i = 0; i < money.length(); i++) {
           if(!Character.isDigit(money.charAt(i))) {
               throw new IllegalArgumentException("[ERROR] 입력하신 금액에 숫자 이외의 다른 문자가 있습니다.");
           }
       }
       if (Integer.parseInt(money)%1000 != 0) {
           throw new IllegalArgumentException("[ERROR] 입력하신 금액이 천원 단위가 아닙니다.");
       }
    }
}
