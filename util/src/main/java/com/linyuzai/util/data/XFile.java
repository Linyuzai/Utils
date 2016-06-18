package com.linyuzai.util.data;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/18 0018.
 */
public class XFile {

    private XFile() {
    }

    /**
     * @param path like a/b/c
     * @param name like 123.txt
     */
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
            }
        return null;
    }
}
