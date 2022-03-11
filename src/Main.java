import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.print("\nтест 1 - проверка очередности запуска (метод join())\n");

        Msggg t1 = new Msggg("1 - поток 1.1 сработал\n");
        Msggg t2 = new Msggg("1 - поток 1.2 сработал\n");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.print("\nтест 2 - проверка очередности запуска (метод synchronized())\n");

        new Msg("2 - поток 2.1 сработал\n").start();
        new Msg("2 - поток 2.2 сработал\n").start();

        sleep(5000);

        System.out.print("\nтест 3 - запуск сразу всех потоков, нарушение очередности\n");

        Msggg t3 = new Msggg("3 - поток 3.1 сработал\n");
        Msggg t4 = new Msggg("3 - поток 3.2 сработал\n");

        t3.start();
        t4.start();

        new Msgg("3 - поток 3.3 сработал\n").start();
        new Msgg("3 - поток 3.4 сработал\n").start();

    }

}
