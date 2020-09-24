package com.pack.safflower.util.httputils.urlMd5;

import com.pack.safflower.util.httputils.TimeUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UriMd5Utils {
    public static UriMd5Utils uriMd5Utils;

    public static UriMd5Utils getInstance() {
        if (uriMd5Utils == null) {
            uriMd5Utils = new UriMd5Utils();
        }
        return uriMd5Utils;
    }

    public String getMD5_16(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes(StandardCharsets.UTF_8));
            byte[] encryption = md5.digest();
            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }
            //16位大写
            return strBuf.toString().substring(8, 24).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public String getMD5_32(String info) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(info.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;

    }

    public String getMD5_32(String info, boolean isUpperCase) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(info.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            if (isUpperCase) {
                reStr = stringBuffer.toString().toUpperCase();
            } else {
                reStr = stringBuffer.toString().toLowerCase();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;

    }

    public String getMd5Token(Map map) {
        return getMD5_32(SpliValue(map) + "" + TimeUtils.getInstance().getStringNowDate());
    }

    public String SpliValue(Map map) {
        String splitString = "";
        if (map != null && map.size() > 0) {
            Set<String> keySet = map.keySet();
            Iterator<String> iter = keySet.iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                splitString += map.get(key);
            }
        }

        return splitString;
    }
}
