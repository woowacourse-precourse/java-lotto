package lotto.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class LottoTool {


  public static float calcReturnRate(HashMap<Prize, Integer> result) {
    return 1.0f;
  }
  //변환
  public static List<Integer> convertToIntegerList(String[] inputList) {
    List<Integer> numberList = new ArrayList<>();
    for (int i = 0; i < inputList.length; i++) {
      numberList.add(Integer.parseInt(inputList[i]));
    }
    return numberList;
  }

}
