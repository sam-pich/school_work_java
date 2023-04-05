import java.util.Random;

public class Customer {
    private int arrivalTime;
    private int initialNumberOfItems;
    private int numberOfItems;
    private static final int MAX_NUM_ITEMS = 10;
    

    public Customer(int arrivalTime){
        this.arrivalTime = arrivalTime;


        Random generator;
        generator = new Random();

        int numItems;
        numItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
        initialNumberOfItems = numItems;
        numberOfItems = numItems;
        
    }


    public int getArrivalTime() {

        return arrivalTime;
    }

    public int getNumberOfItems() {     
        return numberOfItems;
    }

    public int getNumberOfServedItems() {

        return initialNumberOfItems - numberOfItems;
    }

    public void serve(){
        numberOfItems--;
    }

}
