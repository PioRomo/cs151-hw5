import java.util.Random; 
public class Player implements Runnable{

    static Boolean isRunning = true;
    static Boolean isOver = false; 


    
    @Override
    public void run() {
        Random random = new Random(); 
        while(isRunning || !isOver){
            int r = random.nextInt(100) + 1;
            System.out.println(Thread.currentThread().getName() + ": " + r);
            if(r == 75 || r == 99){
                try {
                    isOver = true; 
                    isRunning = false; 
                    if(r == 75){
                        throw new GameOverException("Forbidden number! " + Thread.currentThread().getName() + " loses!");
                    }
                    else{
                        throw new GameOverException("Winner! "  + Thread.currentThread().getName());
                    }
                   
                } catch (GameOverException e) {
                    e.printStackTrace();
                }
            }

            Thread.yield(); 
            
        }
    } 

    public static void main(String[] args){
        Player p1 = new Player(); 
        Player p2 = new Player(); 
        Thread player1 = new Thread(p1);
        player1.setName("Player 1");
        player1.start();

        Thread player2 = new Thread(p2);
        player2.setName("Player 2");
        player2.start(); 
    }
    
}
