package lotto.view.exception;

public class CantDivideByThousandToZeroException extends IllegalArgumentException {

    public CantDivideByThousandToZeroException() {
        super("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }
}
