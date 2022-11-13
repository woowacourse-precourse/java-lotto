package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkWinNumber(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkMoney(String Money){
        if(Integer.valueOf(Money)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하셔야 합니다.");
        }
    }

    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        String Money = readLine();
        checkMoney(Money);
        int numBuy = Integer.valueOf(Money)/1000;
        return numBuy;
    }
    public static void printLotto(List<Integer> Lotto){
        System.out.println(Lotto);
    }
    public static List<Integer> generateLotto(){
        List<Integer> Lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(Lotto);
        return Lotto;
    }
    public static void checkWinNumber(List<Integer> winNumber){
        Set<Integer> numSet = new HashSet<>(winNumber);
        if(numSet.size() != winNumber.size()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자가 6개가 아닙니다.");
        }
    }
    public static List<Integer> winner(){
        String winNum = readLine();
        List<String> winner = Arrays.asList(winNum.split(","));
        List<Integer> winNumber = winner.stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
        new Lotto(winNumber);
        return winNumber;
    }
    public static int bonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(readLine());
        return bonus;
    }
    public int getWin(List<Integer> LottoNum){
        int checkWin = 0;
        for(int i : this.numbers){
            if(LottoNum.contains(i)) checkWin++;
        }
        return checkWin;
    }
    public boolean getBonus(int bonus, List<Integer> LottoNum){
        boolean flag = false;
        if(LottoNum.contains(bonus)){
            flag = true;
        }
        return flag;
    }
    public String checkWin(boolean flag){
        if(flag == true) {
            return "5b";
        }
        return "5";
    }
}
