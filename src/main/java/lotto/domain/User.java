package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User{
    public static int money = Integer.parseInt(Console.readLine());

    private final List<List<Integer>> userNumList;

    public User(List<List<Integer>> userNumList){
        this.userNumList = userNumList;
        for (int i = 0; i< money / 1000; i++) {
            String str = Console.readLine();
            String tempList[] = str.split(",");

            userNumList.add(stringToNum(tempList));
        }
    }


    public static List<Integer> stringToNum(String[] strlist){
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < strlist.length; i++){
            numList.add(Integer.parseInt(strlist[i]));
        }
        return numList;
    }

    public static int bonusNum = Integer.parseInt(Console.readLine());


}