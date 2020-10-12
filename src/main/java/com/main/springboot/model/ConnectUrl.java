package com.main.springboot.model;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class ConnectUrl {

    public String getData(String urlName) {
        try {
            URL url = new URL(urlName);
            URLConnection urlCon = url.openConnection();
            long length = urlCon.getContentLengthLong();
            if (length <= 0L) {
                System.out.println("No connection");
                return "";
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
                StringBuffer sb = new StringBuffer();

                String inputLine;
                while((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }

                br.close();
                return sb.toString();
            }
        } catch (Exception e) {
            return "";
        }
    }
/*
    public String postDate(String idKassa, int result, String log) {//ToDo: fix it!
        try {
            String postData = "idKassa=" + idKassa + "&result=" + result + "&log=" + log + "";
            System.out.println(postData);
            int postDataLength = postData.length();
            URL url = new URL(this.urlName);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setAllowUserInteraction(false);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            Throwable var9 = null;

            try {
                wr.writeBytes(postData);
                wr.close();
                DataInputStream dis = new DataInputStream(conn.getInputStream());
                StringBuffer answer = new StringBuffer();

                String nextline;
                while((nextline = dis.readLine()) != null) {
                    answer.append(nextline);
                }

                dis.close();
                String var13 = answer.toString();
                return var13;
            } catch (Throwable var24) {
                var9 = var24;
                throw var24;
            } finally {
                if (wr != null) {
                    if (var9 != null) {
                        try {
                            wr.close();
                        } catch (Throwable var23) {
                            var9.addSuppressed(var23);
                        }
                    } else {
                        wr.close();
                    }
                }

            }
        } catch (MalformedURLException var26) {
            var26.printStackTrace();
            return "";
        } catch (IOException var27) {
            var27.printStackTrace();
            return "";
        }
    }

 */
}