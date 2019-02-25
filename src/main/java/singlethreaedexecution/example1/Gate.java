package singlethreaedexecution.example1;

/**
 * SharedResource (공유자원)
 * 문을 표현하는 클래스, 사람이 지나갈 때 이름과 출신지를 기록한다.
 * thread-safe 하지 않다.
 */
public class Gate {
    // 통과한 사람 수
    private int counter = 0;
    // 마지막에 통과한 사람의 이름
    private String name = "Nobody";
    // 그 사람의 출신지
    private String address = "Nowhere";

    // 문을 통과하는 메소드
    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public String toString() {
        return "No." + counter + " : " + name + ", " + address;
    }

    // 사람 이름과 출신지의 첫 문자 일치 여부 확인 (멀티스레드에서 이상생김)
    /*
     * 결과 :
     * ****BROKEN*****No.512 : Bobby, Brazil
     * ****BROKEN*****No.878 : Alice, Alaska
     * ****BROKEN*****No.1357 : Bobby, Brazil
     * ****BROKEN*****No.1628 : Bobby, Brazil
     * */
    // 체크에서 아무것도 검출되지 않았다고 안전을 장담할 수 없다. 해당 결과는 500번 이후에 도출되었다.
    // 디버깅도 믿을 수 없다. 앞글자가 동일하게 찍혔다. ==> check 메소드 실행중에 다른 쓰레드가 잇따라 name, address를 변경했기 때문이다.
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("*****BROKEN*****" + toString());
        }
    }
}
