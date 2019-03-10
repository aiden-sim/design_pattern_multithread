package future.example2;

/**
 * RealData(현실의 데이터) 역할
 * RealData 역할은 실제의 데이터를 나타낸다. (시간이 걸린다.)
 * 실제 데이터를 표현한 클래스, 생성자의 처리에 시간이 걸린다.
 */
public class RealData implements Data {
    private final String content;

    public RealData(int count, char c) {
        System.out.println(" making RealData(" + count + ", " + c + "). BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(" making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
