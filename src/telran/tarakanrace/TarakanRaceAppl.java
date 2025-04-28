package telran.tarakanrace;

import java.util.Scanner;

public class TarakanRaceAppl {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tarakans:");
        int number = scanner.nextInt();

        System.out.println("Enter the distance");
        int distance = scanner.nextInt();

        Thread[] threads = new Thread[number];
        for (int i = 0; i < threads.length; i++) {
            Runnable task = new TarakanRaceImpl(i, distance);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Congratulations to Tarakan #" + TarakanRaceImpl.getWinner() + "! He has won the race!");


    }
}
