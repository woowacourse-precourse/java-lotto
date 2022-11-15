package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoManager {
    private final String ALLOWED_STRING =  "[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}";
    private final Pattern pattern = Pattern.compile("("+ALLOWED_STRING+")");
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public void askWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        checkWinningNum(winningNumber);
        List<Integer> winningNum = Arrays.stream(winningNumber.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        winningNum.stream().forEach(num -> checkLottoNum(num));
        this.winningNumber = winningNum;
    }

    public void askBonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNum = Console.readLine();
            checkBonusNum(bonusNum);
            this.bonusNumber = Integer.parseInt(bonusNum);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    private void checkWinningNum(String winningNum){
        String stripNum = winningNum.strip();
        if(!pattern.matcher(stripNum).matches()){
            throw new IllegalArgumentException("쉼표(,)로 구분해주세요");
        }
        String[] splitNum = stripNum.split(",");
        if(splitNum.length != LottoPublisher.lottoNum){
            throw new IllegalArgumentException("6자리의 숫자를 입력해주세요");
        }
    }

    private void checkBonusNum(String bonusNum){
        try{
            Integer bonusNumber = Integer.parseInt(bonusNum);
            checkLottoNum(bonusNumber);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }

    }

    private void checkLottoNum(Integer num){
        if(num < LottoPublisher.startNum || num > LottoPublisher.lastNum){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
