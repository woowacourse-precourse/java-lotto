package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User{
    public static int money ;

    public final List<Integer> userNumList;
    public static int bonusBall;

    public User(int money, List<Integer> userNumList, int bonusBall){
        this.userNumList = userNumList;
        this.bonusBall = bonusBall;
    }
    public static int getMoney() {
        return Integer.parseInt(Console.readLine());
    }
    public static List<Integer> getUserInput(){
        List<Integer> inputList = new ArrayList<>();

        String str = Console.readLine();
        int[] List = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();
        inputList = Arrays.stream(List).boxed().collect(Collectors.toList());

        System.out.println(inputList);
        return inputList;
    }

    public static int getBonusNum(){
        return Integer.parseInt(Console.readLine());
    }

    public int get_index(int index){
        return userNumList.get(index);
    }

}