package com.android.mylibrary;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkHelper {
    private Context context =  null;

    public NetworkHelper(Context context) {
        this.context = context;
    }

    public String getLocalIP(){
        try {
            
            for( Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                
                NetworkInterface intf = en.nextElement();
                
                for( Enumeration<InetAddress> IpAddr = intf.getInetAddresses();IpAddr.hasMoreElements();) {
                    
                    InetAddress inetAddress = IpAddr.nextElement();
                    
                    if( !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }                
            }
        } catch(SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * https://alvinalexander.com/java/jwarehouse/android/core/java/android/net/DhcpInfo.java.shtml
     * @param addr
     * @return
     */
    public String intToIp(int addr) {
        return  ((addr & 0xFF) + "." +
                ((addr >>>= 8) & 0xFF) + "." +
                ((addr >>>= 8) & 0xFF) + "." +
                ((addr >>>= 8) & 0xFF));
    }

    /**
     * https://stackoverflow.com/questions/5387036/programmatically-getting-the-gateway-and-subnet-mask-details
     * @return
     */
    public String getGatwayIP() {
        String   s_dns1 ;
        String   s_dns2;
        String   s_gateway;
        String   s_ipAddress;
        String   s_leaseDuration;
        String   s_netmask;
        String   s_serverAddress;
        DhcpInfo d;
        WifiManager wifii;

        wifii= (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        d=wifii.getDhcpInfo();

        s_dns1="DNS 1: "+String.valueOf(d.dns1);
        s_dns2="DNS 2: "+String.valueOf(d.dns2);
        s_gateway="Default Gateway: "+String.valueOf(d.gateway);
        s_ipAddress="IP Address: "+String.valueOf(d.ipAddress);
        s_leaseDuration="Lease Time: "+String.valueOf(d.leaseDuration);
        s_netmask="Subnet Mask: "+String.valueOf(d.netmask);
        s_serverAddress="Server IP: "+String.valueOf(d.serverAddress);

        //dispaly them
        return "Network Info\n"+s_dns1+"\n"+s_dns2+"\n"+s_gateway+"\n"+s_ipAddress+"\n"+s_leaseDuration+"\n"+s_netmask+"\n"+s_serverAddress;
    }
}
