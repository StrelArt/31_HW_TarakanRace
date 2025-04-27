package telran.tarakanrace;

import java.util.Scanner;

public class TarakanRaceAppl {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tarakans:");
        int number = scanner.nextInt();

        System.out.println("Enter the distance");
        int distance = scanner.nextInt();

        Runnable[] tasks = new Runnable[number];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new TarakanRaceImpl(i, distance);
            Thread thread = new Thread(tasks[i]);
            thread.start();
        }
    }
}
