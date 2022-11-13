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

    public int getLottoPrice(){
        return this.lottoPrice;
    }

    public void userNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();

        for(String num : numbers.split(",")){
            userNumbers.add(Integer.valueOf(num));
        }
    }

    public List<Integer> getUserNumbers(){
        return this.userNumbers;
    }

    public void userBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        this.bonusNumber = sc.nextInt();
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
