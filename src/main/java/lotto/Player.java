package lotto;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private final int LOTTO_PRICE = 1000;
    private int PurchaseMoney;
    private int total_lotto;
    private Manager manager;
    private List<Integer> winning;
    private List<Lotto> lottos;
    private int Bonus;
    public Player(Manager manager){
        this.manager = manager;
    }

    public void InputPurchaseMoney(){
        String input = readLine();
        if(!manager.isNumber(input))
            throw new IllegalArgumentException("[ERROR] : 금액은 숫자로만 구성된 문자열이어야 합니다.");
        int money = Integer.parseInt(input);
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] : 최소 1000원 이상의 금액을 입력해주세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] : 금액은 1000원으로 나누어 떨어져야 합니다.");
        this.PurchaseMoney = money;
    }

    public void calculateTotalLotto(){
        this.total_lotto = this.PurchaseMoney / this.LOTTO_PRICE;
    }
    public void checkWinningNumber(String input){
        String[] arr = input.split(",");
        if(arr.length != manager.LOTTO_LENGTH)
            throw new IllegalArgumentException("[ERROR] : 당첨번호는 쉼표(,)를 기준으로 6개로 구분되어야 합니다.");
        List<String> list = Arrays.asList(arr);
        if(!manager.ValidityOfNumber(list))
            throw new IllegalArgumentException("[ERROR] : 당첨번호는 반드시 숫자로만 이루어져야 합니다.");
        List<Integer> winnings = new ArrayList<>();
        for(String s : list)
            winnings.add(Integer.parseInt(s));
        if(!manager.ValidRangeOfLottoNumber(winnings))
            throw new IllegalArgumentException("[ERROR] : 당첨번호는 1 ~ 45 범위에 해당하는 숫자여야 합니다.");
        if(manager.OverlapOfLottoNumber(winnings))
            throw new IllegalArgumentException("[ERROR] : 6개의 당첨번호는 모두 다른 숫자여야 합니다.");
        this.winning = winnings;
    }

    public void InputWinningNumber(){
        winning.clear();
        String input = readLine();
        checkWinningNumber(input);
    }

    public void checkBonusNumber(String input){
        if(!manager.isNumber(input))
            throw new IllegalArgumentException("[ERROR] : 보너스번호는 반드시 숫자로만 이루어져야 합니다.");
        List<Integer> list = new ArrayList<>();
        int bonus = Integer.parseInt(input);
        list.add(bonus);
        if(!manager.ValidRangeOfLottoNumber(list))
            throw new IllegalArgumentException("[ERROR] : 보너스번호는 1 ~ 45 범위에 해당하는 숫자여야 합니다.");
        if(winning.contains(bonus))
            throw new IllegalArgumentException("[ERROR] : 보너스 번호는 입력한 당첨 번호와 중복되서는 안됩니다.");
        this.Bonus = bonus;
    }
    public void InputBonusNumber(){
        String input = readLine();
        checkBonusNumber(input);
    }

    public void PurChaseLotto(){
        lottos.clear();
        for(int i=0; i<total_lotto; i++){
            lottos.add(manager.makeLotto());
        }
    }
}
