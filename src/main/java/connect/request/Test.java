package connect.request;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<Integer> data=new ArrayList<>();

    public Test(){
        System.out.println("创建了Test实例");
    }

    public void add(Integer numpy){
        this.data.add(numpy);
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
