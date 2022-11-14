package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }


    public static Map<String, List<Integer>> digitInput(){
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> bonus = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요");
        List<Integer> collect = Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해 주세요");
        Integer bonusNum = Integer.parseInt(Console.readLine());
        bonus.add(bonusNum);
        result.put("collect",collect);
        result.put("bonus",bonus);
        return result;
    }
}
