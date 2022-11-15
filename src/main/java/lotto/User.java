package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private int money;
    private List<Lotto> lottoBag;
    private int threeMatchCount = 0, fourMatchCount = 0, fiveMatchCount = 0, fiveMatchWithOutBonusCount = 0, sixMatchCount = 0;
    private boolean bonusMatch = false;
    private Checker checker = new Checker();

    public enum Prize{
        THREE_MATCH(3, 5000), FOUR_MATCH(4, 50000), FIVE_MATCH(5, 1500000), SIX_MATCH(6, 2000000000), FIVE_MATCH_WITHOUT_BONUS(7, 30000000);
        private final int value;
        private final int money;
        Prize(int value, int money){
            this.value = value;
            this.money = money;
        }
    }

    public void getMoneyForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        }
        catch(Exception e){
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            throw new NoSuchElementException();
        }
        finally {
            validateMoney();
        }
    }
    public void validateMoney(){
        validateMoneyUnit();
        validateMoneyRange();
    }
    public void validateMoneyUnit(){
        if(money % 1000 != 0) {
            System.out.println("[ERROR] 돈은 1000의 단위여야 합니다.");
            throw new NoSuchElementException();
        }
    }
    public void validateMoneyRange(){
        if(money == 0) {
            System.out.println("[ERROR] 돈은 1부터 45 사이의 숫자여야 합니다.");
            throw new NoSuchElementException();
        }
    }
    public void buyLotto() {
        Seller seller = new Seller();
        try {
            validateMoneyUnit();
            validateMoneyRange();
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            return;
        }
        lottoBag = seller.sellLotto(money);
    }

    public void printLotto() {
        List<Integer> sortedLotto;
        System.out.println(lottoBag.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBag) {
            sortedLotto = lotto.getNumbers().stream().sorted((Integer a, Integer b) -> a.compareTo(b)).collect(Collectors.toList());
            System.out.println(sortedLotto);
        }
    }

    public void watchChecker(){
        checker.chooseNumber();
    }
    public void compareLotto() {
        int count;
        for(Lotto userLotto: lottoBag) {
            count = 0;
            bonusMatch = false;

            for (int i = 0; i < userLotto.getNumbers().size(); i++) {
                for (int j = 0; j < checker.getWinNumber().size(); j++) {
                    if (userLotto.getNumbers().get(i) == checker.getWinNumber().get(j)) {
                        count++;
                    }
                }
            }
            compareBonusNumber(userLotto);
            if(count == 6)
                bonusMatch = false;
            else{
                if(bonusMatch == true) {
                    count++;
                }
            }
            updateMatchRecord(count);
        }
    }
    public void updateMatchRecord(int count){
        if (count == Prize.THREE_MATCH.value) {
            threeMatchCount++;
        }
        else if (count == Prize.FOUR_MATCH.value)
            fourMatchCount++;
        else if (count == Prize.FIVE_MATCH.value)
            fiveMatchCount++;
        else if (count == Prize.SIX_MATCH.value && bonusMatch == true)
            fiveMatchWithOutBonusCount++;
        else if(count == Prize.SIX_MATCH.value && bonusMatch == false)
            sixMatchCount++;
    }
    public void compareBonusNumber(Lotto userLotto){
        for(int i = 0; i < userLotto.getNumbers().size(); i++){
            if(userLotto.getNumbers().get(i) == checker.getBonusNumber()) {
                bonusMatch = true;
            }
        }
    }
    public void printResult(){
        double sum = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatchCount +"개");
        System.out.println("4개 일치 (50,000원) - " + fourMatchCount +"개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatchCount +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveMatchWithOutBonusCount +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatchCount + "개");
        sum += Prize.THREE_MATCH.money * threeMatchCount + Prize.FOUR_MATCH.money * fourMatchCount + Prize.FIVE_MATCH.money * fiveMatchCount + Prize.FIVE_MATCH_WITHOUT_BONUS.money * fiveMatchWithOutBonusCount + Prize.SIX_MATCH.money * sixMatchCount;
        System.out.println("총 수익률은 " + sum/this.money*100 + "%입니다.");
    }
}

