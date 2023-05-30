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
           System.out.println(printGame(maxLength));
        }
        System.out.println("VITÓRIA !!");
        System.out.println("Foram "+ plays +" movimentos");

        scan.close();
    }
    public static String printGame(int maxLength){
        

        String tower1[] = new String [maxLength];
        String tower2[] = new String[maxLength];
        String tower3[] = new String[maxLength];

        tower1 = renderTowers2(tower1, stack);
        tower2 = renderTowers2(tower2, stack2);
        tower3 = renderTowers2(tower3, stack3);
 
        String test = "";

        for(int i = maxLength -1; i >=0; i--){
    
            test += "\n" + 
            (tower1[i] == null ? "-" : tower1[i])
            +"\t" + 
            (tower2[i] == null ? "-" : tower2[i])
            + "\t" + 
            (tower3[i] == null ? "-" : tower3[i]);
            
        }  
        test += "\n-------------------\n"
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
    
    public static String[] renderTowers(String[] tower, Node<Integer>temp, Node<Integer>aux, Stack<Integer>stack){
        for (int i = stack.getLength() -1; i >= 0; i--) {

            tower[i] = temp.getInfo().toString();

            temp = temp.getInfo() == 0 ? aux : (temp.getPrevious() == null ? aux : temp.getPrevious());
        }
        return tower;
    }
    public static String[] renderTowers2(String[] tower, Stack<Integer>stack){
        Node<Integer> aux = new Node<Integer>(0);
        aux.setPrevious(aux);
        Node<Integer> temp = stack.getTop();
        
        for (int i = stack.getLength() -1; i >= 0; i--) {

            tower[i] = temp.getInfo().toString();

            temp = temp.getInfo() == 0 ? aux : (temp.getPrevious() == null ? aux : temp.getPrevious());
        }
        return tower;
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
