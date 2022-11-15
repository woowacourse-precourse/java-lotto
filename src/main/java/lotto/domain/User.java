package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.Exceptions.checkBonusNum;
import static lotto.utils.Exceptions.checkInput;
import static lotto.utils.Exceptions.checkDuplicated;

public class User{

    public final List<Integer> userNumList;

    public static int bonusBall;

    public User(List<Integer> userNumList, int bonusBall){
        this.userNumList = userNumList;
        this.bonusBall = bonusBall;
        checkBonusNum(userNumList, bonusBall);
    }

    public static List<Integer> getUserInput(){
        List<Integer> inputList;
        String str = Console.readLine();
        int[] List = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();
        inputList = Arrays.stream(List).boxed().collect(Collectors.toList());
        checkInput(inputList);
        checkDuplicated(inputList);
        return inputList;
    }

    public static int getBonusNum(){
        return Integer.parseInt(Console.readLine());
    }

    public static int getBonusBall(){
        return bonusBall;
    }

    public int getIndex(int index){
        return userNumList.get(index);
    }
}
