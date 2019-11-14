public class Hydra {
    private int numHeads = 0;
    private int numTails = 0;


    public void addTail()
    {
        this.numTails++;
    }

    public void chopTwoTails()
    {
        this.numTails -= 2;
        this.numHeads++;
    }

    public void chopTwoHeads()
    {
        this.numHeads -= 2;
    }

    public int getNumHeads()
    {
        return this.numHeads;
    }

    public int getNumTails()
    {
        return this.numTails;
    }

    public void setNumHeads(int heads)
    {
        this.numHeads = heads;
    }

    public void setNumTails(int tails) {
        this.numTails = tails;
    }

    public void printNumbers()
    {
        System.out.println("\nNumber of heads "+numHeads);
        System.out.println("\nNumber of tails "+ numTails);
    }

    public boolean isDead(boolean twoHeadCut)
    {   boolean dead = false;

        if(numHeads == 0 && numTails == 0 && twoHeadCut)
        {
            dead = true;
        }

        return dead;
    }
}
