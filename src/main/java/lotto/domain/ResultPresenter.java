package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPresenter {
    public List<Integer> winnerNumbers;
    public int bonusNumber;

    public void input(){
        inputWinnerNum();
        inputBonusNum();
    }

    public void inputWinnerNum(){
        System.out.println(Const.ENTER_LOTTO_NUM);
        String winnerNum = Console.readLine();
        winnerNumbers = winnerNumToList(winnerNum);
        System.out.println();
        // validate method 넣기
    }

    public void inputBonusNum(){
        System.out.println(Const.ENTER_BONNUS_NUM);
        bonusNumber = Integer.valueOf(Console.readLine());
        System.out.println();
        // validate method 넣기
    }

    public List<Integer> winnerNumToList(String winnerNum){
        return Arrays.asList(winnerNum.split(",")).stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
