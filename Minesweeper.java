import java.util.*;

public class Minesweeper {
    private final int WIDTH;
    private final int HEIGHT;
    private final int BOMBS;
    private  ArrayList<Tile> tiles;

    public Minesweeper(int height, int width, int bombs){
        WIDTH = width;
        HEIGHT = height;
        BOMBS = bombs;
        tiles = new ArrayList<Tile>();
    }

    public void createGameBoard() {
        ArrayList<Integer> bombIndex = new ArrayList<Integer>();

        for (int i = bombIndex.size(); i < BOMBS; i = bombIndex.size()) {
            int random = new Random().nextInt(WIDTH * HEIGHT);
            boolean douplicate = false;
            for (int bomb : bombIndex){
                douplicate = false;
                if (random == bomb){
                    douplicate = true;
                    break;
                }
            }

            if (!douplicate){
                bombIndex.add(random);
            }
        }

        for (int i = 0; i < WIDTH * HEIGHT; i++){
            boolean isBomb = false;
            for (int bomb : bombIndex) {
                if (i == bomb){
                    isBomb = true;
                    break;
                }
            }

            int xCoord = i % WIDTH + 1;
            int yCoord = i / WIDTH + 1;

            Tile tile = new Tile(isBomb, true, xCoord, yCoord);
            tiles.add(tile);
        }
    }

    public void printGameBoard(boolean showBoard) {
        if (showBoard) {
            for (Tile tile : tiles) {
                if (tile.isBomb()) {
                    tile.revealTile(false);
                }
            }
        }
        printGameBoard();
    }

    public void printGameBoard(){

        System.out.print("    ");
        for (int i = 1; i <= WIDTH; i++){
            if (i < 10){
                System.out.print("  " + i + "   ");
            }
            else {
                System.out.print("  " + i + "  ");
            }
        }
        if (HEIGHT >= 10){
            System.out.print("\n1 ");
        }
        else {
            System.out.print("\n1");
        }

        for (int i = 0; i < WIDTH * HEIGHT; i++){
            if (i % WIDTH == 0 && i != 0){
                int line = i / WIDTH + 1;
                System.out.print(" |\n" + line);
                if (line < 10){
                    System.out.print(" ");
                }
            }
            System.out.print(" | " + tiles.get(i).getTile(false));
        }
        System.out.print(" |");
    }

    public void populateGameBoard(){
        for (Tile tile : tiles){
            int tileIndex = tiles.indexOf(tile);
            int state = 0;

            boolean isUpperTile = false;
            if (tileIndex <= WIDTH) {
                isUpperTile = true;
            }

            boolean isLeftTile = false;
            if (tileIndex % WIDTH == 0) {
                isLeftTile = true;
            }

            boolean isLowerTile = false;
            if (tileIndex >= tiles.size() - WIDTH - 1){
                isLowerTile = true;
            }

            boolean isRightTile = false;
            if ((tileIndex - WIDTH + 1) % WIDTH == 0){
                isRightTile = true;
            }

            if (tile.isBomb()){
                continue;
            }
            else if (isUpperTile && isRightTile){
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH - 1).isBomb()) { state += 1; }
            }
            else if (isLowerTile && isLeftTile){
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH + 1).isBomb()) { state += 1; }
            }
            else if (isLeftTile && isUpperTile){
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH + 1).isBomb()) { state += 1; }
            }
            else if (isRightTile && isLowerTile){
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH -1).isBomb()) { state += 1; }
            }
            else if (isUpperTile){
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH + 1).isBomb()) { state += 1; }
            }
            else if (isLowerTile){
                if (tiles.get(tileIndex - WIDTH -1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
            }
            else if (isLeftTile){
                if (tiles.get(tileIndex - WIDTH + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
            }
            else if (isRightTile){
                if (tiles.get(tileIndex - WIDTH -1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
            }
            else {

                if (tiles.get(tileIndex - WIDTH -1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - WIDTH + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH - 1).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH).isBomb()) { state += 1; }
                if (tiles.get(tileIndex + WIDTH + 1).isBomb()) { state += 1; }
            }

            if (state == 0) {
                tile.setState(" ");
            }
            else {
                tile.setState("" + state);
            }
        }
    }

    public boolean makeMove(int xCoord, int yCoord){
        Tile selectedTile = getTileID(xCoord, yCoord);

        if (selectedTile.isBomb()) {
            for (Tile tile : tiles) {
                if (!tile.isNotFlag() && tile.isBomb()){
                    tile.setState("X");
                }
            }
            return false;
        }

        revealSurroundingTiles(xCoord, yCoord);
        return true;
    }

    private void revealSurroundingTiles(int xCoord, int yCoord) {
        Tile selectedTile = getTileID(xCoord, yCoord);

        if (selectedTile.isBomb() || !selectedTile.isRevealed()) {
            System.out.print("");
        }
        else if (selectedTile.isEmpty()) {
            selectedTile.setState("-");
            selectedTile.revealTile(false);
            revealSurroundingTiles(xCoord - 1, yCoord + 1);
            revealSurroundingTiles(xCoord, yCoord + 1);
            revealSurroundingTiles(xCoord + 1, yCoord + 1);
            revealSurroundingTiles(xCoord - 1, yCoord);
            revealSurroundingTiles(xCoord + 1, yCoord);
            revealSurroundingTiles(xCoord - 1, yCoord - 1);
            revealSurroundingTiles(xCoord, yCoord - 1);
            revealSurroundingTiles(xCoord + 1, yCoord - 1);
        }
        else {
            selectedTile.revealTile(false);
        }
    }

    private Tile getTileID(int xCoord, int yCoord) {
        int tileID = 0;
        
        for (Tile tile : tiles) {
            if (tile.getWidth() == xCoord && tile.getHeight() == yCoord) {
                tileID = tiles.indexOf(tile);
            }
        }
        return tiles.get(tileID);
    }

    public boolean playerWon() {
        int totalTiles = tiles.size() - BOMBS;
        int revealedTiles = 0;
        for (Tile tile : tiles) {
            if (!tile.isRevealed() && tile.isNotFlag()){
                revealedTiles++;
            }
        }
        if (revealedTiles == totalTiles) {
            return true;
        }
        else {
            return false;
        }
    }

    public String setFlag(int xCoord, int yCoord) {
        Tile selectedTile = getTileID(xCoord, yCoord);
        selectedTile.setOriginalState(selectedTile.getTile(true));
        selectedTile.setState("!");
        selectedTile.setReverseHidden(selectedTile.isRevealed());
        selectedTile.revealTile(false);
        selectedTile.setFlag(true);

        return "Flag Set.\n";
    }

    public String removeFlag(int xCoord, int yCoord) {
        Tile selectedTile = getTileID(xCoord, yCoord);
        selectedTile.setState(selectedTile.getOriginalState());
        selectedTile.revealTile(selectedTile.getPreviousHidden());
        selectedTile.setFlag(false);

        return "Flag Removed.\n";
    }
}