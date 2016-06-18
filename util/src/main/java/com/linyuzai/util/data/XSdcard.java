package com.linyuzai.util.data;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class XSdcard {
    private static final File root = Environment.getExternalStorageDirectory();
    private static final String directory = "linyuzai";

    private XSdcard() {
    }

    public static File getRootFile() {
        return root;
    }

    public static String getRootPath() {
        return root.toString();
    }

    public static File getDirectoryFile() {
        File file = new File(root, directory);
        if (!file.exists())
            file.mkdirs();
        return file;
    }

    public static String getDirectoryPath() {
        return getRootPath() + "/" + directory;
    }
}
