package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

import javax.print.attribute.standard.MediaSize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<Integer>(numbers);
        if (set.size() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 존재합니다.");
            throw new IllegalArgumentException();
        }
    }


    public static void game(){
        int cost=0;

        Output.printCost();
        try{cost = Integer.parseInt(Console.readLine());}
        catch (Exception e){
            //컴파일 오류 발생
            System.out.println("[ERROR] 금액이 올바르지 않습니다.");

        }
            int cnt = Output.printOrder(cost);
            //로또 생성
            List<List<Integer>> total = MakeLotto.totallotto(cnt);
            //당청 번호 입력 받기
            String lottonum;
            int bonus;
            Output.printNum();
            lottonum = Console.readLine();
            String[] lottolst = lottonum.split(",");
            List<Integer> numbers = new ArrayList<>();
            for(int i=0;i<lottolst.length;i++){
                numbers.add(Integer.valueOf(lottolst[i]));
            }
            new Lotto(numbers);

            Output.printBonus();
            //보너스 번호 입력받기
            try {
                bonus = Integer.parseInt(Console.readLine());
            }catch (Exception e){
                System.out.println("[ERROR] 숫자입력이 아닙니다.");
                throw new IllegalArgumentException();
            }
            bonuscheck(bonus);

            int[] result = CompareLotto.comparelotto(total,lottolst,bonus);
            Output.printResult(result,cost);

        }

    private static void bonuscheck(int bonus) {
        if(bonus<=0 || bonus>=45){
        System.out.println("[ERROR] 금액이 올바르지 않습니다.");
        throw new IllegalArgumentException();}

    }


    // TODO: 추가 기능 구현
}
