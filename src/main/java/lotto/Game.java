package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private View view;
    private Exception exception;
    private List<Lotto> total_lotto;
    private List<Integer> total_bonus_lotto;

    public void run(){
        init();
        int money = view.requestMoney();
        System.out.println(money);
        lottoNumberSave(money);

    }

    public void lottoNumberSave(int money){
        for(int i=0;i<money/1000;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            total_lotto.add(lotto);
        }
    }
    
    private void init(){
        final Scanner scanner = new Scanner(System.in);
        view= new View(scanner);
        total_lotto = new ArrayList<>();
        total_bonus_lotto =new ArrayList<>();
        exception = new Exception();
    }
}
