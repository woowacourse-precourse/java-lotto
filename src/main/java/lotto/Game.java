package lotto;

import java.util.List;

public class Game {

    private int bonusNumber;

    private int lottoCount;

    private int money;

    private int hitThree;

    private int hitFour;

    private int hitFive;

    private int hitFiveAndBonus;

    private int hitSix;

    private List<Integer> winningNumbers;

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    public int getMoney(){
        return this.money;
    }

    public List<Integer> getWinningNumbers(){
        return this.winningNumbers;
    }

    public void changeBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void changeLottoCount(int lottoCount){
        this.lottoCount = lottoCount;
    }

    public void changeWinningNumbers(List<Integer> winningNumbers){
        if(winningNumbers.contains(null)) throw new IllegalArgumentException("[ERROR} 숫자는 공백이 있을 수 없습니다.");
        this.winningNumbers = winningNumbers;
    }

    public void changehitThree(int hitThree){
        this.hitThree = hitThree;
    }

    public void changehitFour(int hitFour){
        this.hitFour = hitFour;
    }

    public void changehitFive(int hitFive){
        this.hitFive = hitFive;
    }

    public void changehitFiveAndBonus(int hitFiveAndBonus){
        this.hitFiveAndBonus = hitFiveAndBonus;
    }

    public void changehitSix(int hitSix){
        this.hitSix = hitSix;
    }

    public void changeMoney(String inputMoney){
        this.money = validateMoney(inputMoney);;
    }

    public int getHitThree(){
        return this.hitThree;
    }

    public int getHitFour(){
        return this.hitFour;
    }

    public int getHitFive(){
        return this.hitFive;
    }

    public int getHitFiveAndBonus(){
        return this.hitFiveAndBonus;
    }

    public int getHitSix(){
        return this.hitSix;
    }

    private Integer validateMoney(String inputMoney){
        if( money % 1000 != 0 ) throw new IllegalArgumentException("[ERROR] 사용자 투자 금액은 1000으로 나누어떨어져야 유효합니다.");

        try{
            Integer money = Integer.valueOf(inputMoney);
            return money;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효하지않은 투자금액이 입력되었습니다. - 문자, 특수문자, 공백은 입력될수없습니다.");
        }
    }
}
