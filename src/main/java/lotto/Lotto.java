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
}
