## 로또 게임

### class 및 package 로직
1. Application class
    - 로또 게임 실행
    - 사용자 입력 오류시 종료

2. domain package
    - Lotto class : 로또 객체 클래스
    - LottoMachine class : 로또 생성과 검사를 위한 클래스
    - LottoGenerater class : 로또 생성기  클래스
    - Calculator class : 계산기 클래스(로또의 맞춘 갯수 파악 및 게임 결과 반환)

3. util package
    - message package
        + ExceptionMessage enum : 오류에 대한 출력 메시지 모음
        + OutputMessage enum : 출력 메시지 모음
    - LottoConst enum : Lotto 게임에 필요한 상수 모음
    - Rank enum : Lotto 결과의 랭크

4. view package
    - InputView class : input 처리
    - OutputView class : output 처리


### 게임 진행 로직
1. 구입 급액 입력(InputView) -> 입력 값 오류 확인(InputView) 
2. 구입 금액에 맞게 로또 생성(LottoMachine->LottoGenerator) -> 출력(OutputView)
3. 당첨 번호 입력(InputView) -> 당첨 번호 값과 중복 오류 확인(InputView & Lotto)
4. 보너스 번호 입력(InputView) -> 보너스 번호 오류 확인(InputView)
5. 생성한 로또와 당첨 번호를 확인(LottoMachine -> Calculator)
6. 당첨 통계 출력(LottoMachine -> OutputView)







 
