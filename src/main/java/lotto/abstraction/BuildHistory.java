package lotto.abstraction;


import java.util.List;
import java.util.Map;

// 역할 정의 - 처리 결과 생성
public interface BuildHistory {


    int buildBonusNumber();

    Map<Integer, List<Integer>> buildLottoNumbers();

    int buildMatchCount();

    String buildMatchHistory();

    String buildYieldHistory();



}
