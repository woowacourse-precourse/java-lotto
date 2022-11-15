package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public enum RANKING{
        RANK1(2000000000),
        RANK2(30000000),
        RANK3(1500000),
        RANK4(50000),
        RANK5(5000);

        private int reward;
        public int getReward(){
            return reward;
        }
        RANKING(int reward) {
            this.reward = reward;
        }
    }
    private final int LOTTO_PRICE = 1000;
    private int paid;
    public ArrayList<Lotto> lottos = new ArrayList<>();
    private int[] countRanking;
    private long revenue;

    public LottoMachine() {}

    public void getInputMoney(){

        System.out.println("구입 금액을 입력해 주세요");
        String money = Console.readLine();
        validateMoney(money);
        this.paid = Integer.parseInt(money);
    }

    private void validateMoney(String input){
        System.out.println("[ERROR]");
        if(!input.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");

        }
        int money = Integer.parseInt(input);
        if(money == 0  || money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }

    public List<Lotto> createLottoNumber(){
        int cnt = paid / LOTTO_PRICE;
        for(int i=0; i<cnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public void printLottos(){
        System.out.println(paid/LOTTO_PRICE +"개를 구매했습니다.");
        for(Lotto lotto:lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void getResult(List<Integer> winningNum, int bonusNum){
        countRanking = new int[6];
        for(Lotto lotto:lottos){
            List<Integer> numbers =  new ArrayList<>(lotto.getNumbers());
            int rank = getRank(winningNum, bonusNum, numbers);
            if (rank > 5) continue;
            countRanking[rank] += 1;
        }
        calculateRevenue();
    }

    private int getRank(List<Integer> winningNum, int bonusNum, List<Integer> numbers) {
        boolean isBonusNum = numbers.contains(bonusNum);

        numbers.retainAll(winningNum);
        int rank = 8 - numbers.size();

        if(numbers.size()==5 && isBonusNum){
            rank -=1;
        }
        if(numbers.size()==6){
            rank =1;
        }

        return rank;
    }

    public void calculateRevenue(){
        revenue = 0;
        for(int i = 1; i< countRanking.length; i++){
            long reward = RANKING.valueOf("RANK"+i).getReward();
            revenue += reward * countRanking[i];
        }
    }

    public void printResult(){
        String rate = String.format("%.1f", (double) revenue * 100 / paid);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ countRanking[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+ countRanking[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ countRanking[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ countRanking[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ countRanking[1]+"개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }






}
