import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

class Storage<T>{
    private ArrayList<T> typeList;

    public Storage() {
        typeList = new ArrayList<>();
    }

    public void addItem(T something){
        typeList.add(something);
    }

    public void removeItem(int index){
        typeList.remove(index);
    }

    public T getItem(int index){
        return typeList.get(index);
    }

    public int size(){
        return typeList.size();
    }

    public void displayAll(){
        for (T item:typeList){
            System.out.println(item);
        }
    }

    public void printItems(List<T> items){
        System.out.println(items);
    }

}




public class Generic {
    public static void main(String[] args) {
        Storage<Integer> t = new Storage<>();
        for (int i=1; i<5; i++){
            t.addItem(i);
        }
        t.displayAll();

        Storage<String> tt = new Storage<>();
        for (int i=1; i<5; i++){
            tt.addItem(i+i+"");
        }
        tt.displayAll();
    }
}
