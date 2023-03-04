package homework;


import java.util.ArrayList;
import java.util.List;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    List<Customer> customerList=new ArrayList<>();
    public void add(Customer customer) {
        customerList.add(customer);
    }

    public Customer take() {
        Customer last= customerList.get(customerList.size()-1);
        customerList.remove(last);
        return last ;
    }
}
