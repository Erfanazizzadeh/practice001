
import java.util.concurrent.Semaphore;


class Testrun2 implements Runnable{
   private Semaphore sema;
   public Testrun2(Semaphore smi){
       this.sema=smi;
   }
       
    @Override
    public void run(){
  
    Long id =  Thread.currentThread().getId();
    //print testrun
        System.err.println( id +"  your age is 18 years old . ");
        System.err.println(id  +" Finish testrun2");
        sema.release();
    }
  
    
    
}
class Testrun implements Runnable{
    private Semaphore semaphore;
    public Testrun(Semaphore semaphore){
        super();
        this.semaphore=semaphore;
    }
    @Override
    public void run(){
       try{
        semaphore.acquire();
       }catch(InterruptedException e){
           e.printStackTrace();
       }
    Long id =  Thread.currentThread().getId();
        System.out.println( id+ " Hello Im Erfan.");
        System.out.println(id + " Finish testrun1");
        semaphore.release();
    }
        
    
}

public class Test {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
       
            new Thread(new Testrun(sem)).start();
            new Thread(new Testrun2(sem)).start();
        
    }
}
