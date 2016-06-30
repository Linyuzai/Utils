package com.linyuzai.util.base;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class XByte {
    private byte[] bytes;

    public XByte(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public int length() {
        return bytes.length;
    }

    @Override
    public String toString() {
        return bytes.toString();
    }

    @Override
    public byte[] clone() {
        return bytes.clone();
    }

    @Override
    public boolean equals(Object o) {
        return bytes.equals(o);
    }

    @Override
    public int hashCode() {
        return bytes.hashCode();
    }

    public Object toObject() {
        Object obj = null;
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
