package lotto;

public class BonusNumber {

    Integer bonusNumber;

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        if (!Character.isDigit(inputString.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        bonusNumber = Integer.parseInt(inputString);
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
