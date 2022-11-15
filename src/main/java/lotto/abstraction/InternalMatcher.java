package lotto.abstraction;


// 역할 정의 : 내부 처리
public interface InternalMatcher {


    int countMatcher();



    // 일치 여부 검사의 결과 반영
    int resultByMatcher();
}
