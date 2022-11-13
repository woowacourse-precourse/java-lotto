package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User{
    public static int money = Integer.parseInt(Console.readLine());

    private final List<Integer> userNumList;

    public User(List<Integer> userNumList){
        this.userNumList = userNumList;
    }

    String str = Console.readLine();

    public static int bonusNum = Integer.parseInt(Console.readLine());


}