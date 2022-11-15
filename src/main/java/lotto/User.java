package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class User {
    public static int lottoPrice;
    public static int lottoEA;
    private String numberString;
    private List<Integer> userNumbers;
    public static int bonusNumber;
    private List<List<Integer>> lotteryOfUser;

    public void enterPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        this.lottoPrice = Integer.valueOf(Console.readLine());
    }

    public void printLottoEA(){
        lottoEA = this.lottoPrice/1000;
        if((lottoPrice%1000) != 0)
            throw new IllegalArgumentException("[ERROR]1000단위로 구매해야 합니다.");
        System.out.println(lottoEA + "개를 구매했습니다.");
    }

    public int getLottoPrice(){
        return this.lottoPrice;
    }

    public void createLotto(){
        lotteryOfUser = new ArrayList<>();
        for(int ea=0; ea<this.lottoEA; ea++){
            lotteryOfUser.add(randomNumbers());
            System.out.println(lotteryOfUser.get(ea));
        }
    }

    private List<Integer> randomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6)
                .stream().sorted().collect(Collectors.toList());
        return numbers;
    }

    public List<List<Integer>> getLotteryOfUser(){
        return this.lotteryOfUser;
    }

    public void enterWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요");
        this.numberString = Console.readLine();
        enter(numberString);
    }

    public void enterBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.valueOf(Console.readLine());
    }

    private void enter(String nums){
        userNumbers = new ArrayList<>();
        for(String num : nums.split(",")){
            isOutOfRange(Integer.valueOf(num));
        }
    }

    private void isOutOfRange(int num){
        if(num<1 || num>45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        this.userNumbers.add(num);
    }

    public List<Integer> getUserNumbers(){
        return this.userNumbers;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
