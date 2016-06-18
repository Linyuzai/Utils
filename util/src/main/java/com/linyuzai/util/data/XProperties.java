package com.linyuzai.util.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class XProperties extends Properties {
    public static final String TAG = "XProperties";
    private static final String DEFAULT_PATH = XSdcard.getDirectoryPath();
    private static final String DEFAULT_NAME = "xproperties.properties";
    private String path;

    private XProperties(String path) {
        this.path = path;
    }

    /**
     * default path on sdcard/linyuzai/xproperties.properties
     *
     * @return
     */
    public static XProperties getInstance() {
        return getInstance(DEFAULT_PATH, DEFAULT_NAME);
    }

    public static XProperties getInstance(String path, String name) {
        {
            File file = XFile.create(path, name);
            XProperties pro = new XProperties(path + "/" + name);
            try {
                InputStream is = new FileInputStream(file);
                pro.load(is);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pro;
        }
    }

    @Override
    public Object setProperty(String key, String value) {
        super.setProperty(key, value);
        try {
            this.store(new FileOutputStream(this.path), XCharset.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public Object put(Object key, Object value) {
        super.put(key, value);
        try {
            this.store(new FileOutputStream(this.path), XCharset.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public XProperties put(String key, String value) {
        setProperty(key, value);
        return this;
    }

    public String get(String name) {
        return getProperty(name);
    }
}
