package com.demo.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dell
 * at 2018/1/8
 *
 * 属性文件工具类
 */

public class PropsUtil {

    private static final Logger log = LoggerFactory.getLogger(PropsUtil.class);


    public static Properties loadProps(String fileName){
        Properties props = null;
        try( InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)) {
            if(is==null){
                throw new FileNotFoundException(fileName+" file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (Exception e) {
            log.error("load properties file error",e);
            e.printStackTrace();
        }
        return props;
    }

    public static String getString(Properties props ,String name){
        return  getString(props,name,"");
    }

    public static String getString(Properties props ,String name,String defaultValue){
        String value = defaultValue;
        if(props.containsKey(name)){
            value = props.getProperty(name);
        }
        return value;
    }

    public static int getInt(Properties props ,String name){
        return  getInt(props,name,0);
    }

    public static int getInt(Properties props ,String name,int defaultValue){
        int value = defaultValue;
        if(props.containsKey(name)){
            //value = CastUtils.props.getProperty(name);
        }
        return value;
    }
}
