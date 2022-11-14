package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class InputCorrectNumberGenerator {
    public static List<Integer> createInputCorrectNumber() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요");

        String[] InputUserNumber = readLine().split(",");
        List<Integer> CorrectNumber = new ArrayList<>();
        for(int i=0; i<6; i++) {
            CorrectNumber.add(Integer.valueOf(InputUserNumber[i]));
        }
        return CorrectNumber;

        }
    }
