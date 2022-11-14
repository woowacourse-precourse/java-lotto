# JAVA-LOTTO

## 구현 기능 목록
1. 로또 구입 가능 금액 입력
- Error : 입력값 type number가 아닐 때 / 1000원 단위로 떨어지지 않을 떄
2. 로또 번호 6개 발행
- 입력된 금액에 맞춰서(1000단위 당 1장)
- Error : 중복 값 있을 경우 에러
3. 당첨 번호 입력 받음
- 보너스 번호 1개 (기존 6개와 다른)
4. 발행된 로또와 당첨번호 비교
- 로또 당첨 결과 출력
- 로또 수익률 출력


### lotto
- Application.java   
    메인 실행
- GameProcess.java
    게임 메인 로직 실행

### domain
- JAVA-LOTTO의 비즈니스 로직 구현

### view
- INPUT
- OUTPUT
- ERROR OUTPUT

### UTIL
- ERROR HANDLING

## 추가 요구 사항
1. 메소드의 길이 < 15
2. 메소드의 기능은 한가지만
3. else 예약어 쓰지 않는다
4. Java Enum 적용
5. 도메인 로직에 단위 테스트 구현
