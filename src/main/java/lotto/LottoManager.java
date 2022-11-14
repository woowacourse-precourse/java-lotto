package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
  private static final int startInclusive = 1;
  private static final int endInclusive = 45;
  private static final int pickCount = 6;

  private final List<Lotto> lottos;
  private final List<Integer> winningNumbers;

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
      int number;
      try{
        number = Integer.parseInt(element);
      }catch (NumberFormatException e){
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
      }

      if(!((number>=startInclusive) && (number<=endInclusive))){
        throw new IllegalArgumentException("[ERROR] 입력 숫자의 범위를 지켜주세요.");
      }
    }
  }
}
