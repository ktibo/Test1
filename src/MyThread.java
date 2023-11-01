
public class MyThread implements Runnable {

    Thread thread;
    int counter = 0;

    public MyThread(){
        thread = new Thread(this);
    }

    public MyThread(String name){
        thread = new Thread(this, name);
    }

    public static MyThread createAndStart(String name){

        MyThread myThread = new MyThread(name);
        myThread.thread.start();
        return myThread;

    }
    public static MyThread createAndStart(String name, int newPriority){

        MyThread myThread = new MyThread(name);
        myThread.thread.setPriority(newPriority);
        myThread.thread.start();
        return myThread;

    }
    public static MyThread createAndStart(String name, Thread waitThread){

        MyThread myThread = new MyThread(name);
        //if (waitThread != null && waitThread.isAlive()){
        try {
            waitThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.thread.start();
        //}
        return myThread;

    }
    @Override
    public void run() {

        //String currentThread = "currentThread \""+Thread.currentThread().getName()+"\" (obj \""+name+"\")";
        String threadName = thread.getName();
        System.out.println(threadName +" started.");

       ThreadsExamples.testClass.mySynchronizedMethod(threadName);
        //if (thread.getName().equals("my1")) {
           // TestClass.staticMethod();
            //} else {
            //TestClass.staticMethod2();
        //}
//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(thread.getName() +", counter = "+counter++);
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }
}