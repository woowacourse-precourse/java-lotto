package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static List<List<Integer>> Lottos = new ArrayList<>();
    public static void main(String[] args) {
        createAnswer();
        for (int i = 0; i<takeCost(); i++)
            Lottos.add(getLotto());
        printMyLotto(Lottos,takeCost());
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

    public static List<Integer> getLotto(){
        List<Integer> MyLotto = new ArrayList<>();

        while (MyLotto.size() < 7){
            int rndNum = Randoms.pickNumberInRange(1,45);
            if(!MyLotto.contains(rndNum)) MyLotto.add(rndNum);
        }

        return MyLotto;
    }

    public static void printMyLotto(List Lottos, int count){
        System.out.println(count+"개를 구매했습니다.");

        seperateBonus(Lottos);

        for(int i = 0; i < count; i++)
            System.out.println(Lottos.get(i));
    }

    public static List<Integer> seperateBonus(List<List> Lottos){
        List<Integer> Bonuses = new ArrayList<>();

        for(int i = 0; i < Lottos.size(); i++){
            Bonuses.add((Integer) Lottos.get(i).get(6));
            Bonuses.remove(Lottos.get(i).get(6));
        }

        return Bonuses;
    }



}
