package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i=0;i<numbers.size();i++) {
            if (i!=numbers.indexOf(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
    public int CheckLotto(List<Integer> ListLotto) {
        int Count = 0;
        for (int i=0; i<ListLotto.size();i++) {
            int TmpInt = (int)ListLotto.get(i);
            if (numbers.contains(TmpInt)) Count+=1;
        }
        return Count;
    }
    public int CheckValue(int Count,Boolean BonusCheck) {
        if (Count==3) return 0;
        if (Count==4) return 1;
        if (Count==5 && BonusCheck) return 3;
        if (Count==5) return 2;
        if (Count==6) return 4;
        return -1;
    }
    public enum AmountValue{
        Five(5000),
        Forth(50000),
        Three(1500000),
        Two(30000000),
        One(2000000000);

        private final int Money;
        AmountValue(int value) {
            this.Money = value;
        }
    }

    public int PrintResult(List<Integer> Result){
        int SumValue = 0;
        String[] amount = {" (5,000원)"," (50,000원)"," (1,500,000원)",", 보너스 볼 일치 (30,000,000원)"," (2,000,000,000원)"};
        AmountValue[] values = AmountValue.values();
        for (int i=0;i<Result.size();i++) {
            if (i>=3) System.out.printf("%d개 일치%s - %d개\n",i+2,amount[i],Result.get(i));
            else System.out.printf("%d개 일치%s - %d개\n",i+3,amount[i],Result.get(i));
            SumValue+=values[0].Money*(int)Result.get(i);
        }
        return SumValue;
    }
    public Boolean yield(int Total,int Sumval) {
        if (Sumval==0) {
            System.out.println("총 수익률은 0%입니다.");
            return true;
        }
        float yieldval = (float)Sumval/(Total*1000);
        System.out.printf("총 수익률은 %.1f%%입니다.\n",yieldval*100);
        return true;
    }

    public void Statistics(List<List<Integer>> Lottoes,int BonusNum) {
        List<Integer> Result = new ArrayList<>();
        for (int i=0;i<5;i++) Result.add(0);
        for (List ListLotto : Lottoes) {
            int Count = CheckLotto(ListLotto);
            int Judg = CheckValue(Count,ListLotto.contains(BonusNum));
            if (Judg<0) continue;
            Result.set(Judg,Result.get(Judg)+1);
        }
        int SumValue = PrintResult(Result);
        yield(Lottoes.size(),SumValue);
    }

    // TODO: 추가 기능 구현
}
