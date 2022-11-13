# 로또

## 구현 기능 목록
- 숫자 랜덤 뽑기
    - 1~45 범위
    - 6개
    - 사용자가 구매한 로또 수 만큼
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    
    
- 사용자에게 숫자 입력받기
    - 로또 구매 금액
    - 번호는 쉼표를 기준으로
    - 보너스 번호
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다.
    
    
- 사용자 숫자와 로또 당첨 숫자 비교
    - 당첨 내역
    - 수익률 계산
    
    
- 예외상황
    - 사용자 로또 구매 금액이 1,000원으로 나누어 떨어지지 않는 경우
    - 숫자 외의 입력값
    - 로또 번호 개수(6개)
    - 로또 번호 숫자 쉼표 구분
    - 번호 중복
    - `IllegalArgumentException` 발생
    - [ERROR] 문구 설정
    
    
- 테스트 케이스 작성


