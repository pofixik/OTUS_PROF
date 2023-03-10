package homework;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    ArrayDeque<Customer> customerList=new ArrayDeque<>();
    public void add(Customer customer) {
        customerList.add(customer);

    }

    public Customer take() {
        return customerList.removeLast() ;
    }
}
