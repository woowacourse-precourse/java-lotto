package lotto.dto.input;

public class ReadBonusNumberDto {

    private final int bonusNumber;

    public ReadBonusNumberDto(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
