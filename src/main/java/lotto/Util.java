package lotto;

import java.io.BufferedReader;
import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Util {

    final static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int userMoney = 0;

        try {
            String userInput = br.readLine();

            if(isNumber(userInput)) userMoney = Integer.parseInt(userInput);
            if(!isDivisionByThousand(userMoney)) throw new IllegalArgumentException(ErrorMsg.IO_ERR_MSG.getErrorMsg());

            return userMoney;
        } catch (IOException e){ throw new IllegalArgumentException(ErrorMsg.IO_ERR_MSG.getErrorMsg()); }
    }

    public static boolean isNumber(String str){

        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            System.out.println(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());
            throw new IllegalArgumentException(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());
        }
    }

    public static boolean isNumber(String[] strs){

        try{
            for(int i = 0 ; i < strs.length ; i++){
                Integer.parseInt(strs[i]);
            }
            return true;
        }catch(NumberFormatException e){
            System.out.println(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());
            throw new IllegalArgumentException(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());
        }
    }

    public static boolean isDivisionByThousand(int number){

        if(number % 1000 == 0 && number != 0) return true;

        return false;
    }

    public static List<Integer> inputWinNumber() {
        List<Integer> winNumbers = new ArrayList<>();

        PrintUtil.inputWinNumberGuide();

        try {
            String[] inputStr = br.readLine().split(",");

            if(!isNumber(inputStr)) throw new IllegalArgumentException(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());

            winNumbers = strArrChangeIntList(inputStr);
        } catch (IOException e) {throw new IllegalArgumentException(ErrorMsg.IO_ERR_MSG.getErrorMsg());}
        return winNumbers;
    }

    private static List<Integer> strArrChangeIntList(String[] inputStr) {

        List<Integer> newList = new ArrayList<>();

        for(int i = 0 ; i < inputStr.length ; i++){
            newList.add(Integer.parseInt(inputStr[i]));
        }
        return newList;
    }

    public static int inputBonusNumber(List<Integer> winNumber) {
        int bonusNumber = 0;
        PrintUtil.inputBonusNumberGuide();

        try {
            String str = br.readLine();
            if(!isNumber(str)) throw new IllegalArgumentException(ErrorMsg.NUM_FORMAT_MSG.getErrorMsg());

            bonusNumber = Integer.parseInt(str);

            if(winNumber.contains(bonusNumber)) throw new IllegalArgumentException(ErrorMsg.NUM_CONTAIN_MSG.getErrorMsg());

            return bonusNumber;
        } catch (IOException e) {throw new IllegalArgumentException(ErrorMsg.IO_ERR_MSG.getErrorMsg());}
    }

}
