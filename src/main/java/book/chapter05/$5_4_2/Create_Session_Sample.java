package book.chapter05.$5_4_2;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

//使用curator来创建一个ZooKeeper客户端
public class Create_Session_Sample {
    public static void main(String[] args) throws Exception{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
        CuratorFrameworkFactory.newClient("106.54.169.23:2181,106.54.169.23:2182,106.54.169.23:2183",
        		5000,
        		3000,
        		retryPolicy);
        client.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}