package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Exception.*;
import static lotto.FinalOutput.calculate;
import static lotto.FinalOutput.calculateEarn;

import lotto.View.*;

public class Lotto {
    private final List<Integer> numbers;
     public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkWinNumber(numbers);
        this.numbers = numbers;
    }
    private boolean validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ValidateMessage.SIZE_ERROR.print());
        }
        return true;
    }
    public static int checkString(String Money){
        for(int i = 0; i < Money.length() ; i++){
            checkChar(Money.charAt(i));
        }
        return Integer.parseInt(Money);
    }
    public static int buyLotto(){
        System.out.println(InputMessage.MONEY_PAY.print());
        String Money = readLine();
        int numBuy = checkString(Money)/1000;
        checkMoney(Money);
        return numBuy;
    }
    public static void printLotto(List<Integer> Lotto){
        System.out.println(Lotto);
    }
    public static String checkBonus(List<Integer> wnum){
        if(getBonus(bonusNum(),wnum)){
            return(WinNumber.FIVE_BALL_BONUS.getBall());
        }
        return(WinNumber.FIVE_BALL.getBall());
    }
    public static void startLotto(){
        List<List<Integer>> lotto = new ArrayList<>();
        List<String> winCheck = new ArrayList<>();
        int i = 0;
        int buy = buyLotto();
        for(i = 0; i < buy; i++){
            lotto.add(generateLotto());
        }
        printBuy(i);
        for(List<Integer> number : lotto){
            printLotto(number);
        }
        winCheck = getBonus(lotto,getWinCheck(winCheck,lotto));
        calculate(winCheck);
        calculateEarn(winCheck);
    }
    public static void printBuy(int i){
        System.out.println("");
        System.out.println((i)+InputMessage.BUY_NUM.print());
    }
    public static List<String> getWinCheck(List<String> winCheck, List<List<Integer>> lotto){
        List<Integer> winNum = winner();
        for(List<Integer> wnum : lotto){
            winCheck.add(String.valueOf(getWin(wnum,winNum)));
        }
        return winCheck;
    }
    public static List<String> getBonus(List<List<Integer>> lotto, List<String> winCheck){
        if(winCheck.contains(WinNumber.FIVE_BALL.getBall())){
            winCheck.set(winCheck.indexOf(WinNumber.FIVE_BALL.getBall()), checkBonus(lotto.get(winCheck.indexOf(WinNumber.FIVE_BALL.getBall()))));
        }
        return winCheck;
    }
    public static List<Integer> generateLotto(){
        List<Integer> Lotto = new ArrayList<>();
        Lotto.addAll(Randoms.pickUniqueNumbersInRange(1,45,6));
        Lotto.sort(null);
        return Lotto;
    }
    public static List<Integer> winner(){
        System.out.println("");
        System.out.println(InputMessage.WIN_NUM.print());
        String winNum = readLine();
        List<String> winner = Arrays.asList(winNum.split(","));
        List<Integer> winNumber = winner.stream().map(s-> Integer.parseInt(s)).collect(Collectors.toList());
        new Lotto(winNumber);
        return winNumber;
    }
    public static int bonusNum(){
        System.out.println("");
        System.out.println(InputMessage.BONUS_NUM.print());
        int bonus = Integer.parseInt(readLine());
        return bonus;
    }
    public static int getWin(List<Integer> LottoNum,List<Integer> winNum){
        int checkWin = 0;
        for(int i : winNum){
            if(LottoNum.contains(i)) checkWin++;
        }
        return checkWin;
    }
    public static boolean getBonus(int bonus, List<Integer> LottoNum){
        boolean flag = false;
        if(LottoNum.contains(bonus)){
            flag = true;
        }
        return flag;
    }
}
