package threadpermessage.exercise.exercise6.executorservice;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new MiniServer(8888).execute();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
