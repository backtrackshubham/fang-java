package shubham.edu.dsalgo.amazon;

public class Questions {

    /**
     * Find the number of ways the consecutive houses can be painted with two colors such that
     * no two houses having colourToSkip one ofter another
     * @param numHouses
     * @return
     */
    int waysToPaintHouses(int numHouses) {
        char lastPainted = '1';
        char yellow = 'Y'; //toSkip
        char green = 'G';
        int numCanPaint = 0;
        while (numHouses > 0){
            if(lastPainted == 'G'){
                numCanPaint+=2;
            }


            if(lastPainted == 'Y'){
                numCanPaint+=1;
            }
        }

        return numCanPaint;
    }

    public static void main(String[] args) {

    }
}
