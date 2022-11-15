package lotto.abstraction;


import java.util.List;

// 역할 정의 - 처리 결과 생성
public interface BuildHistory {


    int buildBonusNumber();

    List<Integer> buildLottoNumberList();

    int buildMatchCount();

    String buildMatchHistory();

    String buildYieldHistory();



}
