package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public static int amount(){
        int count=0;
        System.out.println("구입금액을 입력해 주세요.");
        try{
            count = Integer.parseInt(Console.readLine())/1000;
        }catch (NumberFormatException e){
            System.out.println(ExceptionType.numError.getName());
        }
        return count;
    }
    public static List<Integer> createWinningnum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNum = new ArrayList<>();
        try{
            StringTokenizer st = new StringTokenizer(Console.readLine(),",");
            for(int i=0;i<6;i++){
                winNum.add(Integer.parseInt(st.nextToken()));
            }
        }catch(IllegalArgumentException e){
            System.out.println(ExceptionType.rangeError.getName());
        }
        return winNum;
    }
    public static List<Integer> createBonusnum(List<Integer> winNum){
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            int bonus = Integer.parseInt(Console.readLine());
            if(winNum.contains(bonus)){
                throw new IllegalArgumentException();
            }
            winNum.add(bonus);
        }
        catch(IllegalArgumentException e){
            System.out.println(ExceptionType.DuplicateError.getName());
        }
        return winNum;
    }
    public static List<List<Integer>> publish(int count){
        System.out.println(count+"개를 구매했습니다.");
        List<List<Integer>> ticket = new ArrayList<>();
        for(int i=0;i<count;i++){
            List<Integer> a = Randoms.pickUniqueNumbersInRange(1,45,6);
            new Lotto(a);
            ticket.add(a);
            System.out.println(a);
        }
        return ticket;
    }
    public static int compare(List<Integer> winNum, List<List<Integer>> ticket, int index){
        int result = -3, bonusnum = winNum.get(6);
        winNum.remove(6);
        for(int i=0;i<ticket.get(index).size();i++){
            if(winNum.contains(ticket.get(index).get(i))){
                result++;
            }
        }
        for(int i=0;i<ticket.get(index).size();i++){
            if(result==2 && bonusnum == ticket.get(index).get(i)){
                result+=2;
            }
        }
        winNum.add(bonusnum);
        return result;
    }
    public static List<Integer> winResult(List<Integer> winNum, List<List<Integer>> ticket){
        List<Integer> result = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        int time=0;
        for(int i=0;i<ticket.size();i++){
            time = compare(winNum,ticket,i);
            if(time>=0 && time<=3){
                result.set(time,result.get(time)+1);
            }
            if(time==4){
                result.set(4,result.get(4)+1);
            }
        }

        return result;
    }
    public static void winningHistory(List<Integer> result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(4) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(3) + "개");
    }
}
