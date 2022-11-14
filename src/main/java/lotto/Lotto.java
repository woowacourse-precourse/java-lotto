package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Lotto {
    private final List<Integer> numbers;
    public enum ErrorMessage {
        ERROR_MESSAGE("[ERROR] "),
        SIZE_ERROR("로또의 당첨 번호는 6개여야 합니다."),
        NO_DUPLICATED("로또의 당첨 번호는 중복되면 안됩니다."),
        WRONG_INPUT_ERROR("구입 금액은 1000원 단위로 입력해야 합니다.");
        private final String message;
        ErrorMessage(String message) {
            this.message = message;
        }
        public String print() {
            return (ERROR_MESSAGE.message + message);
        }
    }
    public enum InputMessage {

        MONEY_PAY("구입금액을 입력해 주세요."),
        BONUS_NUM("보너스 번호를 입력해 주세요."),
        WIN_NUM("당첨 번호를 입력해 주세요.");


        private final String input;

        InputMessage(String input){
            this.input = input;
        }
        public String print(){return input;}
    }
    public enum WinNumber{
        THREE_BALL("3"),
        FOUR_BALL("4"),
        FIVE_BALL("5"),
        FIVE_BALL_BONUS("5b"),
        SIX_BALL("6");

        private final String num;

        WinNumber(String num) { this.num = num; }
        public String getBall(){return num;}
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkWinNumber(numbers);
        this.numbers = numbers;
    }
    private boolean validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.print());
        }
        return true;
    }
    public static boolean checkMoney(String Money){
        if(Integer.valueOf(Money)%1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_ERROR.print());
        }
        return true;
    }
    public static int checkString(String Money){
        for(int i = 0; i < Money.length() ; i++){
            checkChar(Money.charAt(i));
        }
        return Integer.parseInt(Money);
    }
    public static boolean checkChar(char n){
        if( !(n>='0'&& n<='9')){
            System.out.println(ErrorMessage.WRONG_INPUT_ERROR.print());
            throw new NoSuchElementException(ErrorMessage.WRONG_INPUT_ERROR.print());
        }
        return true;
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
    public static List<Integer> generateLotto(){
        List<Integer> Lotto = new ArrayList<>();
        Lotto.addAll(Randoms.pickUniqueNumbersInRange(1,45,6));
        Lotto.sort(null);
        return Lotto;
    }
    public static void checkWinNumber(List<Integer> winNumber){
        Set<Integer> numSet = new HashSet<>(winNumber);
        if(numSet.size() != winNumber.size()){
            throw new IllegalArgumentException(ErrorMessage.NO_DUPLICATED.print());
        }
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
    public static void calculate(List<String> winNum){
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(winNum,WinNumber.THREE_BALL.getBall())+"개");
        System.out.println("4개 일치 (50,000원) - " + Collections.frequency(winNum,WinNumber.FOUR_BALL.getBall())+"개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(winNum,WinNumber.FIVE_BALL.getBall())+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(winNum,WinNumber.FIVE_BALL_BONUS.getBall())+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(winNum,WinNumber.SIX_BALL.getBall())+"개");
    }
    public static void calculateEarn(List<String> winNum){
        double earn = 5000* Collections.frequency(winNum,"3");
        earn += 50000*Collections.frequency(winNum,"4");
        earn += 1500000*Collections.frequency(winNum,"5");
        earn += 30000000*Collections.frequency(winNum,"5b");
        earn += 2000000000*Collections.frequency(winNum,"6");
        earn /= 1000*winNum.size();
        System.out.println("총 수익률은 "+String.format("%.1f",earn*100)+ "%입니다.");
    }
}
