import java.util.*;


public class Pypy{

    public static void main(String[] args)
    {
        int [] heads = new int [50];
        int [] tails = new int [50];
        int counter = 0;
        int numHeads = 0;
        int numTails = 0;
        int turnsToKill = 0;

        //As noted later on in the program these are variables I have created for a variation of this program but not this one in specific.
        /*
        int moveCutHeads = 0;
        int moveCutTwoTails = 0;
        int moveCutOneTail = 0;
        */

        Hydra[] hydra = new Hydra[50];

        boolean notDone = true;
        //boolean badInput = true;
        while(notDone)
        {


            //We are going to scan all inputs into an two dimensional array. Of heads and tails.
            Scanner scan = new Scanner(System.in);

                for(int i = 0; i < 50; i++) {
                    boolean badInput = true;            //This forces a loop to continue until the proper input is met.

                    hydra[i]= new Hydra();

                    do
                    {
                        try {
                            heads[i] = scan.nextInt();
                            tails[i] = scan.nextInt();



                        if(heads[i] == 0 && tails[i] == 0)
                        {
                            System.out.println("Breaking loop");
                            notDone = false;
                            break;
                        }

                        if (heads[i] < 1 || tails[i] < 0 || tails[i] > 100)
                        {
                            throw new IllegalArgumentException();
                        }


                        badInput = false;
                        }
                        catch (Exception e)
                        {
                            System.out.println("\nYour input is invalid.");
                        }
                    }while (badInput);

                    if(heads[i] == 0 && tails[i] == 0)
                    {

                        break;
                    }

                    counter++;   //To keep track of how many of the classes were actually used.

                }

        }


        for(int i = 0; i < counter; i++)
        {
            turnsToKill = 0;

            boolean hydraDead = false;      //The loop will continue to run until the criterea to kill hydra is met.
            boolean twoHeadCut = false;     //To kill hydra the last move must be a cut of exactly two heads.

            numHeads = heads[i];
            numTails = tails[i];
            hydra[i].setNumHeads(numHeads);
            hydra[i].setNumTails(numTails);
            //hydra[i].printNumbers();
            while(!hydraDead)
            {
                numHeads = hydra[i].getNumHeads();
                numTails = hydra[i].getNumTails();


                //This block of code was created for a different program I created with slight differences.
                /*
                moveCutHeads = numHeads + numTails - 2;
                moveCutOneTail = numHeads + numTails + 1;
                moveCutTwoTails = numHeads + numTails - 1;
                */

                if(numHeads >= 2)
                {
                    hydra[i].chopTwoHeads();
                    twoHeadCut = true;
                    turnsToKill++;
                }
                else if(numTails >= 2)
                {
                    hydra[i].chopTwoTails();
                    turnsToKill++;
                }
                else
                {
                    hydra[i].addTail();
                    turnsToKill++;
                }

                if(twoHeadCut)
                {
                    hydraDead = hydra[i].isDead(twoHeadCut);
                }


            }

            System.out.println("\nCase " + i + " with "  + heads[i] + " head(s)" + " and " + tails[i] + " tail(s) will take " + turnsToKill + " turns to kill hydra.");
        }


    }


}
