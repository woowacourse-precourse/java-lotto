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

  public int setWinningNumbers(String winningNumbers){
    if(correctWinningNumber(winningNumbers.split(",")) == -1){
      return -1;
    }

    for(String number : winningNumbers.split(",")){
      this.winningNumbers.add(Integer.parseInt(number));
    }

    return 0;
  }

  private int correctWinningNumber(String[] winningNumbers){
    if(winningNumbers.length != pickCount){
      System.out.println("[ERROR] 당첨 번호의 개수가 맞지 않습니다.");
      return -1;
    }
    for(String element : winningNumbers){
      int number = isNumber(element);
      if(number == -1){
        return -1;
      }

      if(checkRange(number) == -1){
        return -1;
      }
    }
    return 0;
  }

  private int isNumber(String input){
    int number;
    try{
      number = Integer.parseInt(input);
    }catch (NumberFormatException e){
      System.out.println("[ERROR] 숫자만 입력해주세요.");
      return -1;
    }

    return number;
  }

  private int checkRange(int number){
    if(!((number>=startInclusive) && (number<=endInclusive))){
      System.out.println("[ERROR] 입력 숫자의 범위를 지켜주세요.");
      return -1;
    }
    return 0;
  }

  public int setBonnusNumber(String bonnusNumber){
    if(correctBonnusNumber(bonnusNumber.split(" ")) == -1){
      return -1;
    }
    this.bonnusNumber = Integer.parseInt(bonnusNumber);

    return 0;
  }

  private int correctBonnusNumber(String[] bonnusNumbers){
    if(bonnusNumbers.length != 1){
      System.out.println("[ERROR] 보너스 번호의 개수가 맞지 않습니다.");
      return -1;
    }

    int number = isNumber(bonnusNumbers[0]);
    if(number == -1){
      return -1;
    }

    if(checkRange(number) == -1){
      return -1;
    }
    return 0;
  }

  public void winALotto(Prize prize){
    for(Lotto lotto : lottos){
      int getRightCount = 0;
      boolean getBonnus = false;
      for(int number : winningNumbers){
        if(lotto.getNumbers().contains(number)){
          getRightCount++;
        }
      }
      if(lotto.getNumbers().contains(bonnusNumber)){
        getBonnus = true;
      }

      prize.renewRank(getRightCount, getBonnus);
    }
  }
}
