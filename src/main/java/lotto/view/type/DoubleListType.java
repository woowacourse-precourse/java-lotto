package lotto.view.type;

import java.util.List;

public class DoubleListType extends ViewType {
  private final List<List<Integer>> doubleList;

  public DoubleListType(List<List<Integer>> doubleList){
    this.doubleList = doubleList;
  }

  public List<List<Integer>> getString(){
    return doubleList;
  }
}
