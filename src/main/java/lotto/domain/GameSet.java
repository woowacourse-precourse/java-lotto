package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSet {
    final static int PRICE_SIZE = 6;
    Lotto awardLotto;
    int lottoCount;
    private int totalPrize;
    private int bonusNumber;
    private int[] gameCount;
    public static final String message = "[ERROR]";
    public GameSet(){
        gameCount = new int[PRICE_SIZE];
        totalPrize = 0;
        init();
    }
    public void setAwardLotto(Lotto awardLotto){
        this.awardLotto = awardLotto;
    }
    public void init() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        try{
            lottoCount=Integer.parseInt(Console.readLine());
        }catch (NumberFormatException n){
            System.out.println(message);
            throw new IllegalArgumentException();
        }

        if(lottoCount%1000!=0){
            System.out.println(message);
            throw new IllegalArgumentException();
        }
        lottoCount/=1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
    }
    public void updateGameSet(LottoProperties lottoProperties){
        gameCount[lottoProperties.getIndex()]++;
        totalPrize+=lottoProperties.getPrice();
    }
    public Lotto getAwardLotto(){
        return awardLotto;
    }
    public void setBonusNumber(List<Integer> bonusNumber){
        this.bonusNumber=bonusNumber.get(0);
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    public int[] getGameCount(){
        return gameCount;
    }
    public int getTotalPrize(){
        return totalPrize;
    }
    public int getLottoCount(){
        return lottoCount;
    }
}
