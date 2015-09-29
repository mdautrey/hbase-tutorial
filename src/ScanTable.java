import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ScanTable {
    public static void main(String[] args) throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        HTable hTable = new HTable(configuration, "emp");
        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
        scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"));

        ResultScanner scanner = hTable.getScanner(scan);
        for(Result result = scanner.next(); result != null; result = scanner.next())
            System.out.println("Found row " + result.toString());

        scanner.close();
    }

}
