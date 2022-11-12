package InputOutput;

import java.util.ArrayList;
import java.util.List;

public class Revert {

    public static List<Integer> revertStringArrayToIntegerList(String[] inputString){
        List<Integer> inputList = new ArrayList<Integer>();
        for (String s : inputString) {
            inputList.add(Integer.parseInt(s));
        }
        return inputList;
    }
}
