package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public List<List<Integer>> lottoRandomNumber(Integer number) {   //사용자 입력값을 받는 것
        List<List<Integer>> numberResult = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numberResult.add(numbers);
//            for (int j = 0; j < numbers.size(); j++) {
                System.out.println(numbers);
//            }

        }
        return numberResult;
    }

        public int inputBuyPrice() {
            return Integer.parseInt(readLine());
        }

        public void lottoDetailList () {

            String lottoList = new String();
            lottoList = readLine();
        }

        public List<Integer> lottoToList (String UserIn){

            String lottoList = new String();
            List<Integer> lottoToList1 = new ArrayList<>();
            Set<Integer> repeatDestroy = new HashSet<Integer>(lottoToList1);

            if (!lottoList.equals(UserIn)) {
                lottoToList1.contains(lottoList);
            }

            return (List<Integer>) repeatDestroy;
        }

        public void bonusNumber () {
            Set<Integer> bonusNumber1 = new HashSet<>();
            String bonusNumberInput = new String(String.valueOf(bonusNumber1));
            bonusNumberInput = readLine();
        }

    }

