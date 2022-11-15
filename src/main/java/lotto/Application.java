package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String money = Console.readLine(); //로또 구입 금액 입력

        List<Integer> numbers=new ArrayList<>(); //로또 당첨 번호 입력받기

        for (int i=0; i<5; i++){
            int input = Integer.parseInt(Console.readLine());
            numbers.add(input);
        }

        int bonus = Integer.parseInt(Console.readLine()); //보너스 번호 입력받기


        // TODO: 프로그램 구현
    }
}
