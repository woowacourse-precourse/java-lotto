package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int lottoPrice;
    private int lottoEA;
    private String winningNumbers;
    private List<Integer> userNumbers;
    private int bonusNumber;
    private ArrayList<List<Integer>> lotteryOfUser;

    public void enterPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        this.lottoPrice = sc.nextInt();
    }

    public void printLottoEA(){
        lottoEA = this.lottoPrice/1000;
        if((lottoPrice%1000) != 0)
            throw new IllegalArgumentException();
        System.out.println(lottoEA + "개를 구매했습니다.");
    }

    public int getLottoPrice(){
        return this.lottoPrice;
    }

    public void createLotto(){
        for(int ea=0; ea<this.lottoEA; ea++){
            System.out.println(randomNumbers());
        }
    }

    private List<Integer> randomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        lotteryOfUser = new ArrayList<List<Integer>>();
        this.lotteryOfUser.add(numbers);
        return numbers;
    }

    public void enterWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요");
        Scanner sc = new Scanner(System.in);
        this.winningNumbers = sc.nextLine();
        enter(winningNumbers);
    }

    public void enterBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        this.bonusNumber = sc.nextInt();
    }

    private void enter(String nums){
        userNumbers = new ArrayList<>();
        for(String num : nums.split(",")){
            this.userNumbers.add(Integer.valueOf(num));
        }
    }

    public List<Integer> getUserNumbers(){
        return this.userNumbers;
    }



    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
