package com.yr.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileUtil {
    
    private static final int BYTE_UNIT = 1024;
    private static final int BYTE_L = 5;
    
    private FileUtil() {

    }

    /**
     * 根据模板文件得到一个新文件
     * @param templXlsx 全路径
     * @param targetFile 全路径
     * @return
     * @throws IOException
     */
    public static File getExcelByTemplate(File templXlsx, File targetFile)
        throws IOException {
        copyFile(templXlsx, targetFile);
        return targetFile;
    }

    /**
     * 复制文件
     * 
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile)
        throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[BYTE_UNIT * BYTE_L];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (null != inBuff) {
                inBuff.close();
            }
            if (null != outBuff) {
                outBuff.close();
            }
        }
    }
}
