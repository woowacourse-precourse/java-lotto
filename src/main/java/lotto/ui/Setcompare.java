package lotto.ui;

import java.util.List;

// 사용자 수와 로또의 수 비교
public class Setcompare {
    Compare[] compare=null;
    public Setcompare(int count, NumberSplit numberSplit, List<List<Integer>> lottoNumbers) {
        compare = new Compare[count];
        for (int i = 0; i < count; i++) {
            compare[i] = new Compare(numberSplit.getNumber(), lottoNumbers.get(i));
        }
    }
    public Compare[] getCompare(){ return compare;}
}
