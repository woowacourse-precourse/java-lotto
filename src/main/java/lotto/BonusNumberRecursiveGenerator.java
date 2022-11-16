package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusNumberRecursiveGenerator {
    public static int BonusNumberRecursive (List<Integer> CorrectNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");

        String InputBonusNumber = readLine(); // 입력 읽기


        int bonusNumber = Integer.parseInt(InputBonusNumber); // 파싱 string to int
        if(!CorrectNumber.contains(bonusNumber)) {
            return bonusNumber;
        }
        return BonusNumberRecursiveGenerator.BonusNumberRecursive(CorrectNumber);
    }
}
