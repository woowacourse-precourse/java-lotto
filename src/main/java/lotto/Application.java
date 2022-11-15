package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String money = Console.readLine(); //로또 구입 금액 입력

        List<Integer> numbers=new ArrayList<>(); //로또 당첨 번호 입력받기

        try{
            for (int i=0; i<5; i++){
                int input = Integer.parseInt(Console.readLine());
                if(numbers.contains(input)){ //중복 제거하기
                    throw new IllegalArgumentException();
                }
                if (input<1 | input>45){ //숫자 범위 체크
                    throw new IllegalArgumentException();
                }
                numbers.add(input);
            }

            if (numbers.size() != 6) { //사용자 입력(당첨 번호) 사이즈 체크
                throw new IllegalArgumentException();
            }

        }

        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        int bonus = Integer.parseInt(Console.readLine()); //보너스 번호 입력받기


        // TODO: 프로그램 구현
    }
}
