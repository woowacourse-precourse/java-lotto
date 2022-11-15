package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorHandler.unCorrectMoneyInputException;
import static lotto.exception.ErrorHandler.unCorrectMoneyRangeException;
import static lotto.utils.GenerateLottoNumbers.generateLottoNumber;
import static lotto.view.InputLotto.getInput;

public class GameSet {
    final static int PRICE_SIZE = 6;
    Lotto awardLotto;
    int lottoCount;
    private List<Lotto> generatedLotto = new ArrayList<>();
    private int totalPrize;
    private int bonusNumber;
    private int[] gameCount;
    public static final String message = "[ERROR]";
    public GameSet(){
        gameCount = new int[PRICE_SIZE];
        totalPrize = 0;
        init();
    }
    public void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.add(new Lotto(generateLottoNumber()));
            System.out.println(generatedLotto.get(i).getNumbers());
        }
    }
    public void init() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        try{
            lottoCount=Integer.parseInt(Console.readLine());
        }catch (NumberFormatException n){
            unCorrectMoneyRangeException();
        }
        if(lottoCount%1000!=0){
            unCorrectMoneyInputException();
        }
        lottoCount/=1000;
        System.out.println(lottoCount+"개를 구매했습니다.");
        generateLotto();
        generateAwardLotto();
    }
    public void generateAwardLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        awardLotto= new Lotto(getInput());
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = getInput().get(0);
    }
    public void updateGameSet(LottoProperties lottoProperties){
        gameCount[lottoProperties.getIndex()]++;
        totalPrize+=lottoProperties.getPrice();
    }
    public Lotto getAwardLotto(){
        return awardLotto;
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
    public List<Lotto> getGeneratedLotto(){
        return generatedLotto;
    }
}
