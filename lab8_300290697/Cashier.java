public class Cashier {
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int totalItemsServed;
    private int customersServed;

    public Cashier() {
        customersServed = 0;
        totalCustomerWaitTime = 0;
        totalItemsServed = 0;
        currentCustomer = null;
        queue = new ArrayQueue<Customer>();
    }


    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }
    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public int getTotalCustomersServed() {
        return customersServed;

    }

    public void serveCustomers(int currentTime) {
        if (currentCustomer == null) {
            if (!queue.isEmpty()) {
                currentCustomer = queue.dequeue();
                totalCustomerWaitTime += (currentTime - currentCustomer.getArrivalTime());

            }
            else return;
        }

         
        currentCustomer.serve();
        totalItemsServed++;

        if (currentCustomer.getNumberOfItems() <= 0) {
            customersServed++;
                    currentCustomer = null;
            
        }
    }

    public String toString() {
        return "Total Customers Served: " + customersServed + ", Total Customer Wait Time: " + totalCustomerWaitTime 
        + ", Total Items Served: " + totalItemsServed;
    }


}
