package homework;


import javax.management.ImmutableDescriptor;
import java.security.KeyStore;
import java.util.*;

public class CustomerService extends ImmutableDescriptor {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private  TreeMap< Customer, String> list =  new TreeMap<>(Comparator.comparingInt(o -> (int) o.getScores()));
    private  TreeMap< Customer, String> listsh =  new TreeMap<>(Comparator.comparingInt(o -> (int) o.getScores()));

    private  Map.Entry<Customer, String> shallowCopy;
    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> keyMin=list.ceilingEntry(list.firstKey());

        if (!shallowCopy.getValue().equals("init")){
        for(Map.Entry<Customer, String> entry: list.entrySet()) {
            if (!entry.getKey().getName().equals(shallowCopy.getKey().getName())
                    && entry.getKey().getId()==shallowCopy.getKey().getId()){
                entry.getKey().setName(shallowCopy.getKey().getName());
            }
        }}

        long value,min;
        min=list.firstKey().getScores();
        for(Map.Entry<Customer, String> entry: list.entrySet())
        {
           value = entry.getKey().getScores();

            if (Long.valueOf(min).compareTo(Long.valueOf(value)) > 0) {
                min = value;
                keyMin = entry;
            }
            shallowCopy= new AbstractMap.SimpleEntry<>(new Customer(keyMin.getKey()), keyMin.getValue());
        }
        return keyMin ;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
       list.putAll(listsh);
       return list.higherEntry(customer);


    }

    public void add(Customer customer, String data) {

        Customer initialCustomer= new Customer(customer);
        list.put(initialCustomer,data);  list.put(new Customer(initialCustomer.getId(),initialCustomer.getName(),initialCustomer.getScores()), data);
        listsh.put(new Customer(customer),data);
        shallowCopy= new AbstractMap.SimpleEntry<>(null,"init");

    }


}
