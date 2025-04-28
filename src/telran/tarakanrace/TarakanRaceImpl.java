package telran.tarakanrace;

public class TarakanRaceImpl implements Runnable {
    private int name;
    private int distance;
    private static volatile int winner = -1;

    public TarakanRaceImpl(int name, int distance) {
        this.name = name;
        this.distance = distance;
    }


    @Override
    public void run() {

        for (int i = 0; i < distance; i++) {
            System.out.println("Tarakan " + name + ", distance: " + i);
            try {
                int tarakanSleep = (int) (Math.random() * 4) + 2;
                Thread.sleep(tarakanSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        if (winner == -1) {
            winner = name;
        }
    }

    public static int getWinner() {
        return winner;
    }

}
