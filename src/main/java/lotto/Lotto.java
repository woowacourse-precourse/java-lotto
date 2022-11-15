package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    private static int bonusNum;
    
    private static int tickets = 0;
    
    enum winnings {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        NONE
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    
    public static Integer read() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        try{
            int purchaseAmount = Integer.valueOf(Console.readLine().strip());
            return purchaseAmount;
        }
        catch(Exception e){
            System.out.println("[ERROR]");
            throw e;
        }
    }
    
    public static void numOfTickets(int money){
        if(money % 1000 > 0){
            tickets = 0;
        }
        if (money > 1000){
            tickets = money / 1000;
        }
    }
    
    public static void printTickets(List<List> tickets){
        System.out.println( tickets + "개를 구매했습니다.");
        for (List l : tickets){
            System.out.println(l);
        }
    }
    
    public static List<String> winInput(){
        List<String> results = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningInput = Console.readLine().strip();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine().strip();
        results.add(winningInput);
        results.add(bonus);
        return results;
    }
    
    public static List<Integer> validateWin(List<String> input) throws IllegalArgumentException{
        IllegalArgumentException exception = new IllegalArgumentException();
        String[] temp = input.get(0).split(",");
        List<Integer> result = new ArrayList<>();
        for(int n = 0; n < 6; n++){
            int tempNum = val(input, n);
            if (result.contains(tempNum)){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw exception;
            }
            result.add(tempNum);
        }
        bonusNum = val(input, 7);
        if(result.contains(bonusNum)){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw exception;
        }
        return result;
    }
    
    public static int val(List<String> in, int num) throws IllegalArgumentException{
        try{
            int temp = Integer.valueOf(in.get(num));
            if (temp < 45 && temp > 0){
                return temp;
            }
        }
        catch(Exception e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
        return 0;
    }
    
    public static List<Integer> gen(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    
    public static List<List> purchased(){
        List<List> result = new ArrayList<>();
        for(int i = 0; i < tickets; i++){
            List<Integer> gen = gen();
            result.add(gen);
        }
        return result;
    }
    
    public static void loop(List<Integer> win, List<List> purchased){
        int first = 0, second = 0 , third = 0, fourth = 0, fifth = 0;
        for(List l : purchased){
            boolean bonus = false;
            int common = compare(win, l);
            if(win.contains(bonusNum)){
                bonus = true;
            }
            winnings ticketWin = winAmount(common, bonus);
            if(ticketWin == winnings.FIRST){
                first++;
            }
            if(ticketWin == winnings.SECOND){
                second++;
            }
            if(ticketWin == winnings.THIRD){
                third++;
            }
            if(ticketWin == winnings.FOURTH){
                fourth++;
            }
            if(ticketWin == winnings.FIFTH){
                fifth++;
            }
        }
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - "+ fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth +"개");
        System.out.println("5개 일치 (1,500,000원) - " + third +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first +"개");
        
        float result = calculate(tickets, first,second,third,fourth,fifth);
        float temp = Math.round(result * 100) / 100;
    
        System.out.println("총 수익률은 " + temp +"%입니다.");
    }
    
    public static float calculate(int spent, int first, int second, int third, int fourth, int fifth){
        int won = 0;
        
        won += (first * 2000000000);
        won += (second * 30000000);
        won += (third * 1500000);
        won += (fourth * 50000);
        won += (fifth * 5000);
    /*
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
    */
        
        if(won == 0){
            return 0;
        }
        float s = (spent * 1000), w = won;
        float result = w / s;
        return result;
    }
    
    public static int compare(List<Integer> win, List<Object> ticket){
        int result = 0;
        for(Object o : ticket){
            if(win.contains(o)){
                result++;
            }
        }
        return  result;
    }
    
    public static winnings winAmount(int count, boolean bonus){
        if (count == 6){
            return winnings.FIRST;
        }
        if (count == 5 && bonus == true){
            return winnings.SECOND;
        }
        if(count == 5){
            return winnings.THIRD;
        }
        if(count == 4){
            return winnings.FOURTH;
        }
        if(count == 3){
            return winnings.FIFTH;
        }
        return winnings.NONE;
    }
}
