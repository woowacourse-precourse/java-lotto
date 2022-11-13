package lotto.controller;

import java.util.HashMap;
import java.util.List;

public class LottoNumberConfirmManagement {
  private final HashMap<Integer, Integer> winningTickets;
  private final int BONUS_NUMBER = 100;

  private static List<List<Integer>> numberIntegration;
  private static List<Integer> winningNumbers;
  private static int bonusNumber;

  LottoNumberConfirmManagement(List<List<Integer>> numbersIntegration, List<Integer> winningNumbers, int bonusNumber) {
    winningTickets = new HashMap<>();
    this.numberIntegration = numbersIntegration;
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  public HashMap<Integer, Integer> getWinningTickets() {
    return winningTickets;
  }

  public void checkNumbers() {
    for (List<Integer> numbers : numberIntegration) {
      winningTickets.put(checkNumber(numbers), winningTickets.getOrDefault(checkNumber(numbers), 0) + 1);
    }
  }

  private int checkNumber(List<Integer> numbers) {
    int sameNumberCount = 0;
    for (int number : numbers) {
      if (winningNumbers.contains(number)) {
        sameNumberCount++;
      }
      if(sameNumberCount==5){
        if(checkBonusNumber(numbers)){
          sameNumberCount = BONUS_NUMBER;
        }
      }
    }
    return sameNumberCount;
  }

  private boolean containNumber(int number, List<Integer> winningNumbers) {
    if (winningNumbers.contains(number)) {
      return true;
    }
    return false;
  }

  private boolean checkBonusNumber(List<Integer> numbers){
    if(numbers.contains(bonusNumber)){
      return true;
    }
    return false;
  }
}
