package bonus;

import java.util.*;

public class OwnMap {

     static  class Entry {
        Object key;
        Object value;

         public Object getValue() {
             return value;
         }

         public void setValue(Object value) {
             this.value = value;
         }




        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

         @Override
         public String toString() {
             return "key : " + key.toString()+ " value : " +value;
         }
     }

    public  static LinkedHashMap<Object,Object> map;

    OwnMap () {
        map = new LinkedHashMap<>();
    }

    static void insert(Object key,Object value) {
        if(!map.containsKey(key)) {
            map.put(key,value);
        }
    }

    static void  remove(Object key) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }

    static Entry search(Object key) {
        if(map.containsKey(key)) {
            Entry entry  = new Entry();
            entry.setKey(key);
            entry.setValue(map.get(key));
            return entry;
        }
        return  null;
    }

    static Object getRandom() {
         int size =  map.keySet().size();
         Random ran = new Random();
         int index = ran.nextInt(size);
         List<Map.Entry> indexedList = new ArrayList<Map.Entry>(map.entrySet());
         return  indexedList.get(index).getValue();

    }



    public static void main(String[] ar) {
        bonus.OwnMap ownMap  = new bonus.OwnMap();
        ownMap.insert(1,"ashu");
        ownMap.insert(2,"kunal");
        ownMap.insert(3,"ajit");
        ownMap.insert(4,"pandu");
        ownMap.insert(5,"barni");
        ownMap.insert(6,"karry");
        //System.out.println(ownMap.getRandom());
        ownMap.remove(6);
        System.out.println(ownMap.search(2).toString());
        //int s= 10;

        //System.out.println(x);

    }


}
