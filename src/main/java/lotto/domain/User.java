package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User{
    public static int money = Integer.parseInt(Console.readLine());

    private final List<Integer> userNumList;

    public User(List<Integer> userNumList){
        this.userNumList = userNumList;
    }

    public static List<Integer> getUserInput(){
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i< money / 1000; i++) {
            String str = Console.readLine();
            inputList = (List<Integer>) Arrays.stream((str.split(","))).mapToInt(Integer::parseInt);

        }
        return inputList;
    }

    public static List<Integer> stringToNum(String[] strlist){
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < strlist.length; i++){
            numList.add(Integer.parseInt(strlist[i]));
        }
        return numList;
    }

    public static int bonusNum = Integer.parseInt(Console.readLine());
    public int get_index(int index){
        return userNumList.get(index);
    }

}