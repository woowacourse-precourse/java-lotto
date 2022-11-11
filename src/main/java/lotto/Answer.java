package lotto;

import java.util.ArrayList;

public class Answer {
    ArrayList<Integer> answers = new ArrayList<>();
    // 여기에 여섯자리짜리 로또 정답이 들어가고 일급 컬렉션으로 래핑됨.

    Answer(ArrayList<Integer> userInputToList) {
        validity(userInputToList);
        this.answers = userInputToList;
    }

    private void validity(ArrayList<Integer> userInput) {
        //userinput이 유효한지 확인. 이 전에 스트링을 잘라내는 과정이 필요. -> 잘라내기만 하고 가져오자.
    }
}
// ******   로또 정답 6자리 리스트를 감싸고 있는 일급 컬렉션   ******//
// ******   Lotto 클래스는 난수로 생성한 6자리 값을 감싸는 일급 컬렉션으로, 다른 일급컬렉션으로 감쌀 것이다.   ******//
