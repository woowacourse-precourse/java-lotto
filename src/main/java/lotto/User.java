package lotto;

import java.util.List;
import java.util.Scanner;

public class User {
    private int lottoPrice;
    private int lottoEA;
    private List<Integer> userNumbers;
    private int bonusNumber;

    public void buyLotto(){
        System.out.println("구매 금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        this.lottoPrice = sc.nextInt();
    }

    public void printLottoEA(){
        lottoEA = lottoPrice/1000;
        if((lottoEA%=1000) != 0)
            throw new IllegalArgumentException();
        System.out.println(lottoEA + "개를 구매했습니다.");
    }

    public int getLottoPrice(){
        return this.lottoPrice;
    }

    public List<Integer> userNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();

        for(String num : nums.split(",")){
            this.userNumbers.add(Integer.valueOf(num));
        }

        return this.userNumbers;
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
