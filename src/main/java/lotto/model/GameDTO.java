package lotto.model;

import java.math.BigDecimal;
import java.util.List;

public class GameDTO {
    private Lotto winningNumber;
    private int bonusNumber;
    private int[] winningCount = new int[5];
    private double winningAmount;
    private BigDecimal returnOfRate;
    private int purchaseAmount;

    public void setWinningNumber(List<Integer> number) {
        this.winningNumber = new Lotto(number);
    }
    public Lotto getWinningNumber() {
        return this.winningNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(double winningAmount) {
        this.winningAmount = winningAmount;
    }

    public BigDecimal getReturnOfRate() {
        return returnOfRate;
    }

    public void setReturnOfRate(BigDecimal returnOfRate) {
        this.returnOfRate = returnOfRate;
    }

    public int[] getWinningCount() {
        return winningCount;
    }

    public void setWinningCount(String type) {
        int arrayIndex = TypeWinning.valueOf(type).getTable1Value();
        this.winningCount[arrayIndex] += 1;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public enum TypeWinning {
        THREE(0,3),
        FOUR(1,4),
        FIVE(2,5),
        FIVE_BONUS(3,7),
        SIX(4,6);
        private int table1Value;
        private int table2Value;
        TypeWinning(int table1Value, int table2Value) {
            this.table1Value = table1Value;
            this.table2Value = table2Value;
        }
        public int getTable1Value() {
            return table1Value;
        }
        public int getTable2Value() {
            return table2Value;
        }
    }
}
