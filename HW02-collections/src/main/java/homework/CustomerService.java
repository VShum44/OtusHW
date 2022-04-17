package homework;

import java.util.*;

public class CustomerService {

    private Map<Customer,String> customerStorage;

    public CustomerService(){
        customerStorage = new HashMap<>();
    }

    public Map.Entry<Customer, String> getSmallest() {

        TreeMap<Customer,String> customerByScore = getMapSortedByScore(customerStorage);
        Map.Entry<Customer,String> smallestEntry = customerByScore.firstEntry();
        Customer customerCopy = makeCopy(smallestEntry.getKey());

        return Map.entry(customerCopy, smallestEntry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        TreeMap<Customer,String> customerByScore = getMapSortedByScore(customerStorage);

        Map.Entry<Customer,String> entry = customerByScore.higherEntry(customer);
        if (entry == null) return null;

        Customer customerCopy = makeCopy(entry.getKey());

        return Map.entry(customerCopy, entry.getValue());
    }

    public void add(Customer customer, String data) {
      customerStorage.put(customer,data);
    }

    private TreeMap<Customer,String> getMapSortedByScore(Map<Customer,String> customers){

        Comparator<Customer> comparatorByScore = new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return (int) (o1.getScores() - o2.getScores());
            }
        };

         TreeMap<Customer,String> customerByScore = new TreeMap<>(comparatorByScore);
         customerByScore.putAll(customers);

        return customerByScore;

    }

    private Customer makeCopy(Customer customer){

        Customer copy = new Customer(
                customer.getId(),
                customer.getName(),
                customer.getScores());

        return copy;
    }
}
