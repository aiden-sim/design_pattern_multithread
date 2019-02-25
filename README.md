## Thread
- 순차, 병렬, 병행
  - 순차(sequential) : 복수의 업무를 순서대로 처리
  - 병렬(parallel) : 복수의 업무를 동시에 처리
  - 병행(concurrent) : 순차, 병렬보다 추상도가 높은 표현. 한 개의 업무를 어떠한 순서로 처리하든 상관 없는 여러 개의 작업.(분할)
- 데이터 레이스(data race) or 레이스 컨디션(race condition)
  - 쓰레드 A와 쓰레드 B가 경쟁함으로써 예기치 않게 발생하는 상황
- 배타제어 or 상호배타
  - 쓰레드가 어느 부분을 실행하고 있으면 다른 쓰레드가 그 부분을 실행할 수 없게 만드는 것 (synchronized)
  - 쓰레드의 배타제어를 하는 구조를 모니터(monitor)라 하며 락을 취하고 있는 것을 모니터를 소유(own)한다. 혹은 락을 홀드(hold)한다고 표현한다.
- 쓰레드 협조
  - wait set (쓰레드 대합실)
    - 모든 인스턴스는 wait set을 가진다. 그 인스턴스의 wait 메소드를 실행한 후 동작을 정지하고 있는 쓰레드들의 집합이다.
    - 쓰레드는 wait 메소드를 실행하면 동작을 일시 정지하고 wait set에 들어간다.
    - 다음 한 상황이 발생하면 wait set에서 나올 수 있다.
      - 1) 다른 쓰레드에서 notifiy 메소드에 의해 깨어난다.
      - 2) 다른 쓰레드에서 notifyAll 메소드에 의해 깨어난다.
      - 3) 다른 쓰레드에서 interrupt 메소드에 의해 깨어난다.
      - 4) wait 메소드가 타임아웃 된다.
  - wait 메소드 (쓰레드를 wait set에 넣는다)
    - wait 메소드를 사용하면 쓰레드가 wait set에 들어간다. (쓰레드가 obj 상에서 wait 하고 있다.)
    - 메소드 안에 wait()가 있으면 this.wait()와 같은 의미이므로 실행한 쓰레드는 this의 wait set으로 들어간다.
    - wait 메소드를 실행하기 위해서 쓰레드가 락을 가지고 있어야 하는데(규칙) wait set에 들어갈 때는 락을 일단 해제한다.
  - notify 메소드 (쓰레드를 wait set에서 꺼낸다)
    - notify 메소드를 사용하면 wait set에 있는 쓰레드 한개를 꺼낸다.
    - notify 메소드를 실행하기 위해서는 wait 메소드와 마찬가지로 쓰레드가 락을 가지고 있어야 한다. (규칙)
    - notify 메소드를 실행했을 때 wait set에 대기중인 쓰레드가 여러개 있는 경우 어느 쓰레드가 선택될지는 정해져 있지 않다.
  - notifyAll 메소드 (모든 쓰레드를 wait set에서 꺼낸다)
    - notifyAll 메소드를 사용하면 wait set에 있는 모든 쓰레드를 꺼낸다.
    - notify가 한 개의 쓰레드를 깨우는데 반해 notifyAll은 모든 쓰레드를 깨운다.
    - notify보다 notifyAll을 사용하는 편이 낫다.
  - wait, notify, notifyAll은 Objectc 클래스의 메소드이다.
  - 주의점
    - 락을 가지지 못한 쓰레드가 wait, notify, notifyAll 메소드를 호출하면 IlegalMonitorStateException이 발생된다.
- 쓰레드의 상태 변화
  - NEW, RUNNABLE, TERMINATED, WAITING, TIMED_WAITING, BLOCKED
![state-machine-example-java-6-thread-states](https://user-images.githubusercontent.com/7076334/53339235-1a691180-3949-11e9-8e48-301c386e78ba.png)


