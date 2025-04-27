package telran.tarakanrace;

public class TarakanRaceImpl implements Runnable {
    private int name;
    private int distance;

    public TarakanRaceImpl(int name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    private static volatile boolean isWinner = false;

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
        if (!isWinner) {
            isWinner = true;
            System.out.println("Tarakan " + name + " has won the race!");

        } else {
            System.out.println("Tarakan " + name + " has finished the race.");
        }
    }
}
