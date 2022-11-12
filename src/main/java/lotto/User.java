package lotto;

//import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int Money;
    private ArrayList<Lotto> lottos;
    private float profit;
    public User(int money){
        this.Money = money;
        lottos = new ArrayList<>();
        profit = 0;
    }
    public void buyLotto(){
        System.out.println("금액을 입력하세요");
        String money = Console.readLine();
        int amount = Integer.parseInt(money) ;
        this.Money = this.Money - amount;

        int numberOfLotto = amount/1000;

        for(int i = 0 ; i < numberOfLotto ; i++){
            List<Integer> lottonum = CreateRandomList.createList();

            Collections.sort(lottonum);

            Lotto lotto = new Lotto(lottonum);

            this.lottos.add(lotto);

        }
        printLotto();

    }
    public void printLotto(){
        int size = this.lottos.size();
        for(int i = 0 ; i < size ; i++){
            this.lottos.get(i).printLotto();
        }
    }

    public void checkWinning(WinningNumber winningNumber){

        //임시 당첨 번호

        for(int i = 0 ; i < this.lottos.size() ; i++){
            this.lottos.get(i).checkWin(winningNumber);
        }

    }








}
