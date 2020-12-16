import java.util.Scanner;

public class MinesweeperMain {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Minesweeper game;
        int moveCounter = 1;

        System.out.println("Welcome to: Minesweeper!");
        System.out.println("Created by: Max Kuechen.\n");

        System.out.println("Please enter the height, width, and number of bombs.");
        System.out.println("Bombs will default to 20% of all tiles.\n");

        System.out.print("Enter Height: ");
        int width = Integer.parseInt(scan.nextLine());
        System.out.print("Enter Width: ");
        int height = Integer.parseInt(scan.nextLine());
        System.out.println("If you would like to use the default bomb setting, press enter.");
        System.out.print("Enter Bombs: ");
        String bombs = scan.nextLine();
        System.out.println("\n");

        if (bombs.equals("")) {
            int numBombs = (int)(width * height * 0.2);
            game = new Minesweeper(width, height, numBombs);
        }
        else {
            game = new Minesweeper(width, height, Integer.parseInt(bombs));
        }
        
        game.createGameBoard();
        game.populateGameBoard();
        game.printGameBoard();
        
        while(true) {
            int xChoiceNum = 0;

            System.out.println("\n\nMove: " + moveCounter + ":");
            System.out.println("Please enter desired coordiante. X-coordinate, then y-coordinate.");
            System.out.println("To set a flag type -f after the x coordinate, to remove type -rf. (ex. 3 -f) or (3 -rf).");
            System.out.print("Enter x-coordinate: ");
            String xChoice = scan.nextLine();          
            System.out.print("Enter y-coordinate: ");
            int yChoice = Integer.parseInt(scan.nextLine());
            System.out.print("\n");

            try {
                xChoiceNum = Integer.parseInt(xChoice);
            }
            catch (NumberFormatException e) {
                String[] splitChoice = xChoice.split(" ");
                if (splitChoice[1].equals("-f")){
                    System.out.println(game.setFlag(Integer.parseInt(splitChoice[0]), yChoice));
                }
                else {
                    System.out.println(game.removeFlag(Integer.parseInt(splitChoice[0]), yChoice));
                }
            }

            if (!game.makeMove(xChoiceNum, yChoice)) {
                break;
            }

            if (game.playerWon()){
                break;
            }

            moveCounter++;

            game.printGameBoard();
        }

        if (game.playerWon()) {
            game.printGameBoard();
            System.out.println("\n\nThe Player has won! It took " + moveCounter + " moves.");
        }
        else {
            game.printGameBoard(true);
            System.out.println("\n\nYou loose! Better luck next time. It took " + moveCounter + " moves.");
        }

        scan.close();
    }
}