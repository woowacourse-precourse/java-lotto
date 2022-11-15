package Domain;

public class BonusNumber {

    private void validInputBonusNumber(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

}

