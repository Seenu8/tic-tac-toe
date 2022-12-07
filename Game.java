import java.util.*;
public class Game {
    static String b[];
    static String turn;
    public static void main(String[] args) {
        b=new String[9];
        for(int i=0;i<9;i++){
            b[i]=String.valueOf(i+1);
        }
        System.out.println("Welcome to my Tic Toc Toe");
        print();
        System.out.println("First X turn Enter a number");

        Scanner s=new Scanner(System.in);
        turn="X";
        String winner=null;
        while(winner==null){
            int input;
            try{
                input=s.nextInt();
                if(!(input>0&&input<=9)){
                    System.out.println("Enter valid number");
                    continue;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Enter valid number");
                continue;
            }
            if(b[input-1].equals(String.valueOf(input))){
                b[input-1]=turn;
                if(turn.equals("X"))    turn="O";
                else    turn="X";
                print();
                winner=checkWinner();
            }
            else System.out.println("Slot arlready taken enter different number");
        }
        if(winner.equals("draw"))   System.out.println("The match is draw");
        else    System.out.println("Congratulations "+winner+"'s win the game");
        s.close();
    }
    public static void print(){
        System.out.println("|---|---|---|");
        System.out.println("| "+b[0]+" | "+b[1]+" | "+b[2]+" |");
        System.out.println("| "+b[3]+" | "+b[4]+" | "+b[5]+" |");
        System.out.println("| "+b[6]+" | "+b[7]+" | "+b[8]+" |");
        System.out.println("|---|---|---|");
    }
    static String checkWinner(){
        for(int i=0;i<8;i++){
            String line=null;
            switch(i){
                case 0:line=b[0]+b[1]+b[2];break;
                case 1:line=b[3]+b[4]+b[5];break;
                case 2:line=b[6]+b[7]+b[8];break;
                case 3:line=b[0]+b[3]+b[6];break;
                case 4:line=b[1]+b[4]+b[7];break;
                case 5:line=b[2]+b[5]+b[8];break;
                case 6:line=b[0]+b[4]+b[8];break;
                case 7:line=b[2]+b[4]+b[6];break;
            }
            if(line.equals("XXX"))  return "X";
            else if(line.equals("OOO")) return "O";
        }
        for(int i=0;i<9;i++){
            if(Arrays.asList(b).contains(String.valueOf(i+1)))  break;
            else if(i==8)   return "draw";
        }
        System.out.println(turn+"'s turn:enter a number");
        return null;
    }
}
