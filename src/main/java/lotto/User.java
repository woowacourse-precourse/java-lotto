package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    static Validator val = new Validator();

    public static List<List<Integer>> lottoRandomNumber(Integer number) {
        List<List<Integer>> numberResult = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numberResult.add(numbers);
                System.out.println(numbers);
        }
        return numberResult;
    }

        public static int inputBuyPrice() {
            String InputSix = readLine();
            val.OnlyNumber(InputSix);
            int priceDuplicate = Integer.parseInt(InputSix);
            val.priceDuplicate(priceDuplicate);
            return priceDuplicate;
        }

        public static String lottoListSix(){
            String Sixinput = readLine();
            val.ValidatorLottoInputList(Sixinput);
            return Sixinput;
        }

        public static List<Integer> lottoToList (String UserIn){

            String lottoList = new String();
            List<Integer> lottoToList1 = new ArrayList<>();
            Set<Integer> repeatDestroy = new HashSet<Integer>(lottoToList1);

            if (!lottoList.equals(UserIn)) {
                lottoToList1.contains(lottoList);
                System.out.println(repeatDestroy);
            }


            return (List<Integer>) repeatDestroy;
        }

        public static int bonusNumber() {
            String BonusInput = readLine();
            val.ValidatorBonusRangeNumber(Integer.parseInt(BonusInput));
            return Integer.parseInt(BonusInput);

        }
    }

