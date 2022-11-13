# 오류 해결 과정 정리

1. 돈을 넣어도, 로또 0개를 생성하는 오류 발생
    - 에러 원인 :
      1) Lotto 인스턴스 생성시, 
      2) **isNotDuplicated() 메서드가 항상 false를 반환함**<br>
             -> Set.of(numbers).size() == LOTTO_NUMBER;
      3) Lotto 인스턴스가 생성되지 않음<br><br>
   - 에러 해결법 :
     - Set.of() 를 Set.copyOf()로 바꿔준다
     - Set.of()는 ImmutableCollections 이기 때문에, 
       <br><br><br>

2. UnsupportedOperationException 예외 발생되며, 로또 생성 실패
   - 에러 원인 : 
     1) ApplicationTest의 List.of()로 생성된 입력 바꿀수 없음!!
     2) 로또 클래스 생성시, 매개변수인 `List<Integer> numbers` 정렬하려고 함
     3) **List.of로 생성된 리스트는 ImmutableCollections이므로, 수정(정렬)하려고 하면** 
     4) **UnsupportedOperationException 예외 발생<br><br>**
   - 에러 해결법 :
     - Lotto클래스의 정렬 기능 삭제
     - Lotto인스턴스 생성시, 정렬하지 않고,
     - 출력 시, 값을 복사하여 출력하도록 함.
       <br><br><br>
3. ㅇ
