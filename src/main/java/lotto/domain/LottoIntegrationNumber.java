package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoIntegrationNumber {

  private final List<List<Integer>> numbersIntegration;

  LottoIntegrationNumber(){
    numbersIntegration = new ArrayList<>();
  }

  public void addNumbersIntegration(List<Integer> randomNumbers){
    numbersIntegration.add(randomNumbers);
  }

  public List<List<Integer>> getNumbersIntegration(){
    return numbersIntegration;
  }
}
