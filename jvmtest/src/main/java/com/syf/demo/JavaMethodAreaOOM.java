package com.syf.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dell
 * at 2018/1/10
 *
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        /*while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }*/
        try {
            fillHeap(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fillHeap(int num)throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i=0;i<num;i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }
}
