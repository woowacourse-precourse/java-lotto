package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

    private static final int LOTTO_PRICE = 1000;

    public int getLottoMoney(){
        String money = Console.readLine();
        if(!isNumber(money) || isDivideBy1000(money)){
            throw new IllegalArgumentException("[ERROR]");
        }
        return Integer.parseInt(money);
    }

    private Boolean isNumber(String money){
        return money.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private Boolean isDivideBy1000(String money){
        return Integer.parseInt(money) % LOTTO_PRICE != 0;
    }

    public List<Integer> getWinLottoNumber(){
        String[] needOfChange = Console.readLine().split(",");
        List<Integer> winLottoNumber = new ArrayList<>();
        for(String winNumber:needOfChange){
            winLottoNumber.add(Integer.parseInt(winNumber));
        }
        return winLottoNumber;
    }

    public int getWinBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
