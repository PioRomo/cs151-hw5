public interface Calculator{

    default void multiply(int num1, int num2){
        System.out.println(num1 * num2); 
    }
    public void divide(int num1, int num2); 

    public static void main (String[] args){
        Calculator c1 = new Calculator() {
            public void divide(int num1, int num2){
                try{
                   System.out.println(num1 / num2);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        };
        Calculator c2 = (int num1, int num2) -> System.out.println(num1 / num2); 

        System.out.println("********************************"); 
        c1.divide(10,2); 
        c1.divide(5,0); 
        c2.divide(20,4); 
        c2.multiply(7, 8); 
    }
}
