package lotto.domain;

import java.util.List;

public class LottoReturnCalculation {
    private final List<Integer> gradeCount;
    private final int purchaseQuantity;
    public LottoReturnCalculation(List<Integer> gradeCount, int purchaseQuantity) {
        //validate(gradeCount);
        this.gradeCount = gradeCount;
        this.purchaseQuantity = purchaseQuantity;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public double lottoReturn() {
        Return[] returns = Return.values();
        double totalReturn = 0;
        int gradeCounts = 0;
        for (Return r:returns) {
            gradeCounts = gradeCount.get(r.getGradeCountIndexNum());
            if(gradeCounts > 0) {
                totalReturn += (r.getWinningAmount() * gradeCounts);
            }
        }
        totalReturn /= (purchaseQuantity * 10);
        return totalReturn;
    }

}
