package homework;


import javax.management.ImmutableDescriptor;
import java.util.*;

public class CustomerService extends ImmutableDescriptor {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private  TreeMap< Customer, String> list =  new TreeMap<>(Comparator.comparingInt(o -> (int) o.getScores()));

    private  TreeMap<Customer, String> shallowCopy =  new TreeMap<>(Comparator.comparingInt(o -> (int) o.getScores()));
    public Map.Entry<Customer, String> getSmallest() {

        for(Map.Entry<Customer, String> entry: list.entrySet()) {
            for (Map.Entry<Customer, String> entry2 : shallowCopy.entrySet()) {

                if (!entry.getKey().getName().equals(entry2.getKey().getName()) && entry.getKey().getId()==entry2.getKey().getId()){
                    entry.getKey().setName(entry2.getKey().getName());
                }
            }
        }

        Map.Entry<Customer, String> keyMin=list.ceilingEntry(list.firstKey());
        long value,min;
        min=list.firstKey().getScores();
        for(Map.Entry<Customer, String> entry: list.entrySet())
        {
           value = entry.getKey().getScores();

            if (Long.valueOf(min).compareTo(Long.valueOf(value)) > 0) {
                min = value;
                keyMin = entry;
            }
        }

        return keyMin ;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
       list.putAll(shallowCopy);

       return list.higherEntry(customer);


    }

    public void add(Customer customer, String data) {

        Customer initialCustomer= new Customer(customer);
      //  list.put(initialCustomer,data);
        list.put(new Customer(initialCustomer.getId(),initialCustomer.getName(),initialCustomer.getScores()), data);

        shallowCopy.put(new Customer(customer),data);

    }


}
