package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static Integer takeCost() {
        int cost = 0;

        cost = sc.nextInt();
        CostRight(cost);

        return cost;
    }

    public static void CostRight(int cost) {
        if (cost % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액 오류");
    }

    public static void createAnswer(){
        String answerN = sc.nextLine();
        int flag = 0;

        List<String> answer = List.of(answerN.split(","));
        if(answer.size() != 6)
            throw new IllegalArgumentException("[ERROR] 입력 받은 번호 수 오류");

        for (int i = 0; i<6; i++){
            for(int j = 1; j<6;j++) {
                if (answer.get(i) == answer.get(j)) flag = 1;
                if(flag == 1) break;
            }
        }

        if(flag == 1)
            throw new IllegalArgumentException("[ERROR] 겹치는 번호 입력");
        else createBonus(answer);
    }

    public static List<String> createBonus(List answer){
        String bonus = sc.nextLine();
        if(!answer.contains(bonus)) answer.add(bonus);
        return answer;
    }


}
