# 우테코 3주차 미션 Lotto!

## 구현 목록

1. [x] 난수 로또 생성 클래스 생성
2. [ ] 유저 input 받는 클래스 생성
   1. [x] 인풋 타입 체크
   2. [x] 구입금액 입력 &rarr; 1000원 단위인지 확인
   3. [x] 당첨번호 입력 &rarr; "," 로 구분된 6개 숫자
   4. [x] 보너스 번호 입력 
   5. [x] 각 숫자 유효성 검증
      1. [x] 번호 개수 검증 &rarr; 첫 리스트 사이즈 체크
      2. [x] 번호 크기 검증 &rarr; 1~45 사이
      3. [x] 중복되지 않은 값 검증 &rarr; hashSet 사이즈 체크
      4. [x] 보너스 숫자도 중복되지 않는지 체크 
4. [ ] 메인 로또 로직 
   1. [ ] 통계 로직
   2. [ ] 각 로또마다 일치하는 숫자 계산

### *추가 구현 내용* 
1. [x] exeption 처리 중 error 메세지 출력



### *구현하면서 해겷안된 문제*

1. private 한 메소드의 illegal argument exception을 테스트하기 위해 reflection을 이용하여 invoke 한 결과값을 비교했는데 illegal argument exception이 일어나지 않고 
InvocationTargetException 이 일어났다. 호출한 메소드의 에러를 wrapping 한 것이므로 따로 private 메소드의 exception 처리를 어떻게 하는지 찾지 못했다. <br/> 
결국 illegal 한 상황을 가정하지 않고 올바른 값이 출력되는지 테스트하는 방향으로 테스트를 진행하였다. 