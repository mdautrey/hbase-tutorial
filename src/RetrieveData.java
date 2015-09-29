// coursera intro to cloud computing Hbase tuto

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class RetrieveData {
    public static void main(String[] args) throws IOException, Exception {
        Configuration configuration = HBaseConfiguration.create();
        HTable table = new HTable(configuration, "emp");
        Get g = new Get(Bytes.toBytes("row1"));
        Result result = table.get(g);
        byte[] value = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("name"));
        byte[] value1 = result.getValue(Bytes.toBytes("personal"), Bytes.toBytes("city"));
        System.out.println("name " + Bytes.toString(value) + " city " + Bytes.toString(value1));
    }
}
