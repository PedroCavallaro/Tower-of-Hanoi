import java.util.Scanner;

public class Game {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    private static Stack<Integer> stack3 = new Stack<>();
    private static int plays;

    public void play(){
        Scanner scan = new Scanner(System.in);
        int maxLength = 6;
    
        System.out.println("Com quantos discos deseja jogar? ");
        maxLength = scan.nextInt();
            
        initGame(maxLength);
        
        while(!chekWin(maxLength)){
            String move;

            System.out.println("Faça a jogada. Ex:'ab', 'bc'");
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
                default:
                    System.out.println("Insira uma jogada valida");
            }
           System.out.println(p2(maxLength));
        }
        System.out.println("VITÓRIA !!");
        System.out.println("Foram "+ plays +" movimentos");
        scan.close();
    }
    public static String p2(int maxLength){
        Node<Integer> aux = new Node<Integer>(0);
        aux.setPrevious(aux);
        Node<Integer> temp = stack.getTop() == null ? aux : stack.getTop();
        Node<Integer> temp2 = stack2.getTop() == null ? aux : stack2.getTop();
        Node<Integer> temp3 = stack3.getTop() == null ? aux : stack3.getTop(); 

        String test = "";
        for(int i = 0; i < maxLength; i ++){
            int disk1 = temp.getInfo();
            int disk2 = temp2.getInfo();
            int disk3 = temp3.getInfo();

            test += "\n" + disk1
            +"\t" + 
            disk2
            + "\t" + 
            disk3;

          
            temp = temp.getInfo() == 0 ? aux : (temp.getPrevious() == null ? aux : temp.getPrevious()) ; 
            temp2 = temp2.getInfo() == 0 ? aux: (temp2.getPrevious() == null ? aux : temp2.getPrevious());
            temp3 = temp3.getInfo() == 0 ? aux: (temp3.getPrevious() == null ? aux : temp3.getPrevious());
            
        }  
        test += "\n" + "-------------------\n"
        + "A" + "\t" + "B" + "\t" + "C";
        return test;
        
    }
    public static void validatePlay(Stack<Integer> towerfrom, Stack<Integer>towerTo){
        int removed = 0; 
        try{
            if(towerTo.getTop() == null){
               
                removed = towerfrom.pop();
                towerTo.putOnTop(removed);
                plays++;
            }
            else if(towerfrom.getTop().getInfo() < towerTo.getTop().getInfo()){
                    removed = towerfrom.pop();
                    towerTo.putOnTop(removed);
                    plays++;
            }else{

                System.out.println("Um pino maior não pode ficar em cima de um menor !!");
            }

        }catch(NullPointerException e){

            System.out.println("Não há discos para serem movidos nesta torre");
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
    public static int getPlays() {
        return plays;
    }
    public static void setPlays(int plays) {
        Game.plays = plays;
    }
}
