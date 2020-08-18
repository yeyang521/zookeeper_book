package book.chapter07.$7_1_4;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException.AuthFailedException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

import java.util.ArrayList;
import java.util.List;

/**
 * 清单7-1-4-2 使用正确的scheme进行授权
 */
public class Sample_AuthFailed2 implements Watcher {

    final static String SERVER_LIST = "106.54.169.23:2181,106.54.169.23:2182,106.54.169.23:2183";

    static ZooKeeper zkClient = null;
    static ZooKeeper zkClient_error = null;
    static List<ACL> acls = new ArrayList<ACL>(1);

    static {

        for (ACL ids_acl : Ids.CREATOR_ALL_ACL) {
            acls.add(ids_acl);
        }

    }

    public static void main(String[] args) throws Exception {

        try {
            zkClient = new ZooKeeper(SERVER_LIST, 3000, new Sample_AuthFailed2());
            zkClient.addAuthInfo("digest", "taokeeper:true".getBytes());
            zkClient.create("/zk-book", "".getBytes(), acls, CreateMode.EPHEMERAL);

            zkClient_error = new ZooKeeper(SERVER_LIST, 3000, new Sample_AuthFailed2());
            zkClient_error.addAuthInfo("digest2", "taokeeper:error".getBytes());
            zkClient_error.getData("/zk-book", true, null);
        } catch (AuthFailedException e) {
            e.printStackTrace();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(event.getState());
        System.out.println(event.getType());
    }

}
