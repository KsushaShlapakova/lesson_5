public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    printer("Hello!", 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread thread3 = new Thread(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                                System.out.println("Я поток 3");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread3.start();
                    thread3.join();
                    printer("Hi", 2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //New
        System.out.println(thread2.getState());

        //Runnable
        thread1.start();
        thread2.start();
        System.out.println(thread2.getState());

        //Waiting
        Thread.sleep(1500);
        System.out.println(thread2.getState());


        //Timed waiting
        Thread.sleep(1000);
        System.out.println(thread1.getState());

        //Blocked
        Thread.sleep(1000);
        System.out.println(thread2.getState());

        //Terminated
        Thread.sleep(15000);
        System.out.println(thread2.getState());
    }

    public static synchronized void printer(String data, int num) throws InterruptedException {
        Thread.sleep(5500);
        System.out.println("Поток: "+ num);
    }


}
