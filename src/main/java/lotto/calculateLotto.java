package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

public class calculateLotto {
    Lotto inputLottto;
    int bonusLotto;

    calculateLotto(){
        System.out.println("로또번호 입력하세요");
        String inputLotto = Console.readLine();
        this.inputLottto = convertLottos(inputLotto);
        System.out.println("보너스번호 입력하세요");
        String bonusLotto = Console.readLine();
        this.bonusLotto = convertBonus(bonusLotto);
    }
}
