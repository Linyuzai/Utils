package com.linyuzai.util.data;

import android.support.annotation.Nullable;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class XFile {
    public static final String TAG = "XFile";

    private String path;
    private String name;

    /**
     * is dir
     *
     * @param path
     */
    public XFile(String path) {
        this.path = path;
    }

    /**
     * is file
     *
     * @param path
     * @param name
     */
    public XFile(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public File create() {
        if (path == null)
            return null;
        File dir = new File(path + "/");
        if (!dir.exists())
            dir.mkdirs();
        if (name == null)
            return dir;
        File file = new File(dir, name);
        if (file.exists())
            return file;
        try {
            if (file.createNewFile())
                return file;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param path like a/b/c
     * @param name like 123.txt
     */
    @Nullable
    public static File create(String path, String name) {
        File dir = new File(path + "/");
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dir, name);
        if (!file.exists())
            try {
                if (file.createNewFile())
                    return file;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        return file;
    }
}
