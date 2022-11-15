## 🐪 프로젝트 설명
### 로또 미션
1부터 45까지 서로 다른 수로 이루어진 6개의 숫자를 뽑아 로또를 구매하고
숫자 6개와 보너스 번호 1개로 당첨자를 뽑는 게임 


- 로또 1장 구매 가격 : 1000원
- roulette: 1에서 45까지 중에서 6+1(보너스)개를 무작위 비복원 선택.
- win :     
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원

- (1) player: 로또 구매 금액 입력 (단위: 1천원)
- (2) player : 당첨 번호 입력 (쉼표로 구분)
- (3) player : 보너스 번호 입력
- (4) gameResult : 로또 수량과 번호를 오름차순 정렬로 출력 
- (5) gameResult : player의 당첨 내역 출력 
- (6) gameResult : player의 수익률 출력
- 게임 종료 :  컴퓨터가 선택한 3개의 숫자를 모두 맞히면 종료

### 게임 추가 설명
- (1) : 1천원 단위가 아닐 경우 예외 처리 
- (6) : 수익률은 소수점 둘째 자리에서 반올림

### 게임 구현의 요구 사항
- 에러 상황시 [ERROR]로 시작하는 에러문구 출력 
- 메소드 길이 15라인 이하, 한가지만 담당 
- else 사용X (switch/case 도 사용X)
- Jave Enum  사용 
- Domain Login에 대한 Unit Test 
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
---
## 🐣기능 목록
1. 로또 게임 시작 - player 구매 금액 입력 
2. player 구매금액 정산 
3. player 로또 무작위 추출 
4. 로또 당첨 번호 입력, 보너스 번호 입력
5. player 로또 당첨 확인 
6. player 로또 수익률 확인 
7. 예외 처리




