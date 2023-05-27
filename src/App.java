import java.util.Scanner;

public class App {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int maxLength = 6 ;

        System.out.println("Com quantos discos deseja jogar? ");
        maxLength = scan.nextInt();
        

        initGame(maxLength);
        while(!chekWin(maxLength)){
            String move;

            System.out.println("Escolha a torre");
            move = scan.nextLine();
      
            switch(move.toUpperCase()){
                case "AB":
                    validatePlay(stack, stack2);
                    break;
                case "AC":
                    validatePlay(stack, stack3);
                    break;
                case "BA":
                    validatePlay(stack2, stack);
                    break;
                case "BC":
                    validatePlay(stack2, stack3);
                    break;
                case "CA":
                    validatePlay(stack3, stack);
                    break;
                case "CB":
                    validatePlay(stack3, stack2);
                    break;
            }
            printGame();
        }
        System.out.println("VITÓRIA !!");
        scan.close();
    }
    public static void printGame(){
        System.out.print("\n pino 1" + stack.print());
        System.out.print("\n pino 2" + stack2.print());
        System.out.print("\n pino 3" + stack3.print());
        
    }
    public static void validatePlay(Stack<Integer> towerfrom, Stack<Integer>towerTo){
        int removed = 0; 
            if(towerTo.getTop() == null){
               
                removed = towerfrom.pop();
                towerTo.putOnTop(removed);
            }
            else if(towerfrom.getTop().getInfo() < towerTo.getTop().getInfo()){
                    removed = towerfrom.pop();
                    towerTo.putOnTop(removed);
    
            }else{
                System.out.println("Um pino maior não pode ficar em cima de um menor !!");
            }
        }
    

    public static boolean chekWin(int maxLength){
            return stack3.getLength() == maxLength;
    }

    public static void initGame(int maxLength){
        for (int i = maxLength; i > 0; i--) {
            stack.putOnTop(i);
        }
    }
}