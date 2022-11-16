package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BonusNumberGenerator {
    public static int createBonusNumber(List<Integer> CorrectNumber) {

//        while (true) {
//            System.out.println("보너스 번호를 입력해 주세요.");
//            String InputBonusNumber = readLine();
//            int bonusNumber = Integer.parseInt(InputBonusNumber);
//            if (!CorrectNumber.contains(bonusNumber)) {
//                return bonusNumber;
//            }
//        }

        return BonusNumberRecursiveGenerator.BonusNumberRecursive(CorrectNumber);
    }
}
