package homework;


import javax.management.ImmutableDescriptor;
import java.util.*;

public class CustomerService extends ImmutableDescriptor {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    private  TreeMap<Customer, String> shallowCopy =  new TreeMap<>(Comparator.comparingInt(o -> (int) o.getScores()));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> keyMin=shallowCopy.ceilingEntry(shallowCopy.firstKey());
         long value,min;
         min=shallowCopy.firstKey().getScores();
        for(Map.Entry<Customer, String> entry: shallowCopy.entrySet())
        {
           value = entry.getKey().getScores();

            if (Long.valueOf(min).compareTo(Long.valueOf(value)) > 0) {
                min = value;
                keyMin = entry;
            }
        }
        return keyMin;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        Map.Entry<Customer, String> value= shallowCopy.higherEntry(customer);

        System.out.println(shallowCopy);

        return value; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {

        shallowCopy.put(customer,data);

    }

}
