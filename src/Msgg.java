class Msgg extends Thread{

    // создаем объект, по обращению к которому будем блокировать запуск другого потока
    static Object lock = new Object();

    String message;

    // конструктор класса
    Msgg(String message){
        this.message = message;
    }

    // метод запуска потоков
    public void run(){
            for(int i = 0; i < message.length(); i++){
                // вывод по символьно в консоль символов с сообщения
                System.out.print(message.charAt(i));
                try{
                    // остановка выполнения на время
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    // в случае ошибки прервать выполнение цикла
                    break;
                }
            }
    }
}