package lotto;

import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(@NotNull List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 되어야 합니다.");
        }

        if (Collections.min(numbers) < 0 || Collections.max(numbers) > 46) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        HashSet<Integer> h1 = new HashSet<>(numbers);
        if (h1.size() != 6){
            throw new IllegalArgumentException("[ERROR] 중복되는 수가 있습니다.");
        }

    }

    public enum rating {
        One(200000000),
        Two(30000000),
        Three(1500000),
        Four(50000),
        Five(5000);

        private final int Money;

        rating(int i) {
            this.Money = i;
        }
    }

    public int PrintResult(List<Integer> Result) {
        int SumValue = 0;
        String[] amount = {" (5,000원)", " (50,000원)", " (1,500,000원)", ", 보너스 볼 일치 (30,000,000원)", " (2,000,000,000원)"};
        rating[] values = rating.values();
        for (int i = 0; i < Result.size(); i++) {
            if (i >= 3) {
                System.out.println((i+2) + "개 일치" + amount[i] +  "-" + Result.get(i) + "개");
            }
            else {
                System.out.println((i+3) + "개 일치" + amount[i] + "-" + Result.get(i) + "개");
            }
            SumValue += values[0].Money * (int) Result.get(i);
        }
        return SumValue;

    }

    public int CheckValue(int Count, Boolean BonusCheck) {
        if (Count == 3) return 0;
        if (Count == 4) return 1;
        if (Count == 5 && BonusCheck) return 3;
        if (Count == 5) return 2;
        if (Count == 6) return 4;
        return -1;
    }

    public Boolean yield(int Total, int Sumval) {
        if (Sumval == 0) {
            System.out.println("총 수익률은 0%입니다.");
            return true;
        }
        float yieldval = (float) Sumval / (Total * 1000);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yieldval * 100);
        return true;
    }

    public int CheckLotto(List<Integer> ListLotto) {
        int Count = 0;
        for (int i = 0; i < ListLotto.size(); i++) {
            int TmpInt = (int) ListLotto.get(i);
            if (numbers.contains(TmpInt)) {
                Count += 1;
            }
        }
        return Count;
    }

    public void Statistics(List<List<Integer>> Lottoes, int BonusNum) {
        List<Integer> Result = new ArrayList<>();
        for (int i = 0; i < 5; i++) Result.add(0);
        for (List<Integer> ListLotto : Lottoes) {
            int Count = CheckLotto(ListLotto);
            int Judg = CheckValue(Count, ListLotto.contains(BonusNum));
            if (Judg < 0) continue;
            Result.set(Judg, Result.get(Judg) + 1); // 이 부분 다시 보기 set(index, Element) index에 있는값을 Element로 수정
            // get(index) 값 읽기
        }
        int SumValue = PrintResult(Result);
        this.yield(Lottoes.size(), SumValue);


        // TODO: 추가 기능 구현
    }
}
