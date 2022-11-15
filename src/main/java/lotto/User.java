package lotto;

//import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int Money;
    private int amount;
    private int numberOfLotto;
    private ArrayList<Lotto> lottos;
    private  List<Integer> lottonum;
    private float profit;
    private List<Integer> winningRank;
    public User(int money){
        this.Money = money;
        lottos = new ArrayList<>();
        profit = 0;
        winningRank = new ArrayList<>();
        winningRank.add(0);
        winningRank.add(0);
        winningRank.add(0);
        winningRank.add(0);
        winningRank.add(0);
        winningRank.add(0);
    }

    public void buyLotto(){
        System.out.println("금액을 입력하세요");
        String money = Console.readLine();
        toInt(money);
        this.Money = this.Money - amount;

        numberOfLotto = amount/1000;

        for(int i = 0 ; i < numberOfLotto ; i++){
            lottonum = new ArrayList<>(CreateRandomList.createList());

            Collections.sort(lottonum);

            Lotto lotto = new Lotto(lottonum);
            this.lottos.add(lotto);
        }


    }
    public void printLotto(){
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        int size = this.lottos.size();
        for(int i = 0 ; i < size ; i++){
            this.lottos.get(i).printLotto();
        }
    }

    public void checkWinning(WinningNumber winningNumber){
        //임시 당첨 번호
        for(int i = 0 ; i < this.lottos.size() ; i++){
            //당첨 등수를 return
            int rank = this.lottos.get(i).checkWin(winningNumber);
            winningRank.set(rank,winningRank.get(rank) + 1);
        }
        printResult();
    }

    public void printResult(){
        System.out.println("3개 일치 (5,000원) - " + winningRank.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningRank.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningRank.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningRank.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningRank.get(1) + "개");
    }

    public void computeProfit(){
        //당첨금/money;
        profit = profit + winningRank.get(1) * 2000000000;
        profit = profit + winningRank.get(2) * 30000000;
        profit = profit + winningRank.get(3) * 1500000;
        profit = profit + winningRank.get(4) * 50000;
        profit = profit + winningRank.get(5) * 5000;

        float profitRate = (float)profit / (float)amount  * 100;
        System.out.println("총 수익률은 " + String.format("%.1f",profitRate)+ "%입니다.");

    }
    private void toInt(String money){
        try{
            amount = Integer.parseInt(money) ;
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] : 숫자만 입력해주세요.");
        }
    }
}

