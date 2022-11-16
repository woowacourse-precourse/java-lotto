package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputCorrectNumberGenerator {
    public static List<Integer> createInputCorrectNumber() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요");

        String[] InputUserNumber = readLine().split(",");
        List<Integer> CorrectNumber = new ArrayList<>();

        int LOTTO_NUMBER_LENGTH = 6;

        for(int i=0; i<LOTTO_NUMBER_LENGTH; i++) {
            CorrectNumber.add(Integer.valueOf(InputUserNumber[i]));
        }
        return CorrectNumber;

        }
    }
