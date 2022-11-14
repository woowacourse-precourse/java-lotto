# 구현할 기능 목록

#### [구체화 및 구현 과정](./PROCESS.md)

- LottoShop
    - [x] 금액을 받아 로또를 자동으로 생성
      - 금액이 나누어 떨어지지 않으면 `IllegalArgumentException`을 발생


- Lotto
    - [x] Lotto 입력 형식이 올바른지 체크
      - 입력 형식이 올바르지 않을 경우 `IllegalArgumentException`을 발생
    - [x] 현재 가지고 있는 로또 정보를 String 형식으로 전달함
      - 숫자 오름차순 정리 및 양 옆에 대괄호 추가
      - ex) "[1, 2, 3, 4, 5, 6]"
    - [x] 해당 숫자을 가지고 있는지 확인


- RewardCoordinator
    - [x] 해당 로또가 당첨되었는지를 판단하도 결과를 출력
    - [x] 구매 금액을 통해 수익률을 계산하여 출력


- WinningNumber
    - [x] 당첨 숫자가 제대로 입력되었는지 판단함
    - [x] 로또 숫자가 몇개 당첨되었는지 판단함


- LottoApplicationSetting
  - [x] 해당 정보에 따라 객체(LottoShop)를 생성
  - [x] 해당 정보에 따라 객체(WinningNumber)를 생성
  - [x] 해당 정보에 따라 객체(LottoRewardCoordinator)를 생성
  - LottoSetting
    - [x] 변경 가능한 정보들을 enum 값으로 담고 있음
  - WinningNumberSetting
    - [x] 당첨 번호에 대한 정보를 저장하고 있음 (enum)
  - LottoRewardSetting
    - [x] 각 상금 조건과 상금 정보를 가지고 있음 (enum)
    - [x] 각 상금 정보를 형식에 맞추어 출력
      - ex1) "3개 일치 (5,000원)"
      - ex2) "5개 일치, 보너스 볼 일치 (30,000,000원)"
    - [x] 당첨 번호와 똑같은 숫자의 개수에 따라 상금 조건과 일치하는지 판단


- LottoApplication (전반적인 진행 담당)
  - [x] 전반적인 과정 구현
    - 로또 번호 자동으로 생성 및 내용 출력
    - 당첨 번호 입력 받음
    - 당첨 결과 출력

- ConsoleInput
  - [x] console을 통해 입력값을 받아 Integer 값으로 변환함
    - 입력값이 int 값이 아닌 경우 `IllegalArgumentException`을 발생시킴
  - [x] console을 통해 입력값을 받아 List<Integer> 값으로 변환함
    - 형식이 올바르지 않은 경우 `IllegalArgumentException`을 발생시킴
    - 형식) 34,7,6,28,16,18


- ConsoleOutput
  - [x] 메세지를 입력 받으면 출력하도록 함