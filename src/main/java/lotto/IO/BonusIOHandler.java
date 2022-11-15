package lotto.IO;

import lotto.Domain.Lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusIOHandler extends IOHandler {
    int bonus;

    public int getUserBonus(Lotto lottoAnswer){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = getUserInput();
        validateInput(input);
        this.bonus = Integer.parseInt(input);
        duplicationCheck(lottoAnswer.getNumbers());
        return bonus;
    }

    @Override
    public void validateInput(String input) {
        Pattern pass = Pattern.compile("^([4][0-5]|[1-3][0-9]|[1-9])$");
        Matcher matcher = pass.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 또한 1~45 사이로 입력해주세요");
        }
    }

    // 보너스 번호가 당첨 번호와 중복되는 수인지 체크한다.
    private void duplicationCheck(List<Integer> numbers){
        if(numbers.contains(this.bonus)){
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호는 당첨번호와 중복됩니다.");
        }
    }
}
