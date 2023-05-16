package springtimer;

import java.util.ArrayList;

public class SpringTask {
    private ArrayList<String> userList=new ArrayList<>();
    {
        userList.add("周杰伦");
        userList.add("邓紫棋");
        userList.add("王力宏");
        userList.add("张国荣");
        userList.add("BB");
        userList.add("成龙");
    }
    public void doSomething(){
        for (String user:userList){
            System.out.println("给"+user+"发送一条消息：张xx好帅!!!");
        }
    }
}
