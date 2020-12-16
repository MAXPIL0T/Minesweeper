public class Tile {

    private final boolean ISBOMB; 
    private String orignialState;
    private boolean isHidden; 
    private final int xCOORD;
    private final int yCOORD; 
    private String tileState;
    private boolean previousState;
    private boolean isFlag;

    public Tile(boolean isBomb, boolean isHidden, int WIDTH, int HEIGHT) {
        ISBOMB = isBomb;
        this.isHidden = isHidden;
        xCOORD = WIDTH;
        yCOORD = HEIGHT;
        isFlag = false;
        previousState = false;
        if (ISBOMB) {
            tileState = " X ";
            orignialState = "X";
        }
    }

    public boolean isBomb() {
        return ISBOMB;
    }

    public boolean isEmpty() {
        if (tileState.equals("   ")) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isRevealed() {
        return isHidden;
    }

    public void setState(String state){
            tileState = " " + state + " ";
    }

    public void revealTile(boolean state) {
        isHidden = state;
    }

    public String getTile(boolean overide){
        if (!overide) {
            if (isHidden){
                return "   ";
            }
            else {
                return tileState;
            }
        }
        else return "" + tileState.charAt(1);
    }

    public int getWidth(){
        return xCOORD;
    }

    public int getHeight(){
        return yCOORD;
    }

    public String getOriginalState() {
        return orignialState;
    }

    public void setOriginalState(String state) {
        orignialState = state;
    }

    public void setReverseHidden (boolean state) {
        previousState = state;
    }

    public boolean getPreviousHidden() {
        return previousState;
    }

    public void setFlag(boolean state) {
        isFlag = state;
    }

    public boolean isNotFlag() {
        if (!isFlag) {
            return true;
        }
        else {
            return false;
        }
    }
}