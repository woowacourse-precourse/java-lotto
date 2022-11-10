package lotto.domain;

public class QuantityCalculator {
    public static int calculateProperQuantity(int batAmount) throws IllegalArgumentException{ // 이건 굳이 객체 필요없으니깐 static?
        if (batAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력하셔야 합니다.");
        }

        return batAmount / 1000;
    }
}
