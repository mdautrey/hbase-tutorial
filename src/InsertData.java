// coursera into to cloudcommputing tuto 3
// HBASE

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class InsertData {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HTable hTable = new HTable(conf, "emp");
        Put p = new Put(Bytes.toBytes("row1"));
        p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"),
                Bytes.toBytes("dautrey"));
        p.add(Bytes.toBytes("personal"), Bytes.toBytes("city"),
                Bytes.toBytes("PerrosGuirec"));
        p.add(Bytes.toBytes("professional"), Bytes.toBytes("designation"),
                Bytes.toBytes("manager"));
        p.add(Bytes.toBytes("professional"), Bytes.toBytes("salary"), Bytes.toBytes("500"));
        hTable.put(p);
        System.out.println("data inserted");

        hTable.close();

    }
}
