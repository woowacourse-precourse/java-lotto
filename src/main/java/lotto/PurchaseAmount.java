package lotto;

public class PurchaseAmount {

    private Integer purchaseNumber;

    private Integer purchaseMoney;

    public void inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        if (!checkNumeric(inputString)) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 숫자여야 합니다.");
        }

        purchaseMoney = Integer.parseInt(inputString);
        if (!checkUnit(purchaseMoney)) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위로 입력해야 합니다.");
        }

        this.purchaseNumber = calculatePurchaseNumber(purchaseMoney);
        System.out.println("\n" + this.purchaseNumber + "개를 구매했습니다.");
    }

    public boolean checkNumeric(String input) {
        for(int i=0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUnit(Integer purchaseAmount) {
        if (purchaseAmount % Unit.MONEY_UNIT.getUnit() != 0) {
            return false;
        }
        return true;
    }

    public Integer calculatePurchaseNumber(Integer purchaseAmount) {
        return purchaseAmount / Unit.MONEY_UNIT.getUnit();
    }

    public Integer getPurchaseNumber() {
        return this.purchaseNumber;
    }

    public Integer getPurchaseMoney() { return this.purchaseMoney; }
}
