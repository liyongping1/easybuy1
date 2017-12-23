package cn.bdqn.easybuy.utils;

import javax.xml.bind.DatatypeConverter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/19.
 */
public class NumberUtil {

    public static String getOrderId() throws Exception {
        //mac地址
        InetAddress ia = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        String macStr = DatatypeConverter.printHexBinary(mac);
        //线程Id
        long threadId=Thread.currentThread().getId();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=simpleDateFormat.format(new Date());
        return date+macStr+threadId;
    }
}
