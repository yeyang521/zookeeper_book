package book.chapter05.$5_4_1;
import java.io.IOException;
import org.I0Itec.zkclient.ZkClient;

// 使用ZkClient来创建一个ZooKeeper客户端
public class Create_Session_Sample {
    public static void main(String[] args) throws IOException, InterruptedException {
    	ZkClient zkClient = new ZkClient("106.54.169.23:2181,106.54.169.23:2182,106.54.169.23:2183", 5000);
    	System.out.println("ZooKeeper session established.");
    }
}