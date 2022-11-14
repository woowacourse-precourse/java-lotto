package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
  private static final int startInclusive = 1;
  private static final int endInclusive = 45;
  private static final int pickCount = 6;

  private List<Lotto> lottos;
  private List<Integer> winningNumbers;
  private int bonnusNumber;

  LottoManager(int payment){
    lottos = new ArrayList<>();
    winningNumbers = new ArrayList<>();
    generateLotto(payment);
    showAllLotto();
  }

  private void generateLotto(int payment){
    while(payment-->0){
      List<Integer> numbers =
              Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, pickCount);
      Lotto lotto = new Lotto(numbers);

      lottos.add(lotto);
    }
  }

  private void showAllLotto(){
    for(Lotto lotto : lottos){
      System.out.println(lotto.getNumbers().toString());
    }
  }

  public void setWinningNumbers(String winningNumbers){
    correctWinningNumber(winningNumbers.split(","));
    for(String number : winningNumbers.split(",")){
      this.winningNumbers.add(Integer.parseInt(number));
      System.out.println(number);
    }
  }

  private void correctWinningNumber(String[] winningNumbers){
    if(winningNumbers.length != pickCount){
      throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수가 맞지 않습니다.");
    }
    for(String element : winningNumbers){
      int number = isNumber(element);

      checkRange(number);
    }
  }

  private void checkRange(int number){
    if(!((number>=startInclusive) && (number<=endInclusive))){
      throw new IllegalArgumentException("[ERROR] 입력 숫자의 범위를 지켜주세요.");
    }
  }

  private int isNumber(String input){
    int number;
    try{
      number = Integer.parseInt(input);
    }catch (NumberFormatException e){
      throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }

    return number;
  }

  public void setBonnusNumber(String bonnusNumber){
    correctBonnusNumber(bonnusNumber.split(" "));
    this.bonnusNumber = Integer.parseInt(bonnusNumber);
    System.out.println(this.bonnusNumber);
  }

  private void correctBonnusNumber(String[] bonnusNumbers){
    if(bonnusNumbers.length != 1){
      throw new IllegalArgumentException("[ERROR] 보너스 번호의 개수가 맞지 않습니다.");
    }

    int number = isNumber(bonnusNumbers[0]);

    checkRange(number);
  }
}
