import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

// coursera tutorial (intro to cloud computing)
public class ListTables {
    public static void main(String[] args) throws MasterNotRunningException, IOException {
        Configuration conf = HBaseConfiguration.create();
        HBaseAdmin admin = new HBaseAdmin(conf);

        HTableDescriptor[] tableDescriptor = admin.listTables();

        for(HTableDescriptor htd : tableDescriptor){
            System.out.println(htd.getNameAsString());
        }
    }
}
