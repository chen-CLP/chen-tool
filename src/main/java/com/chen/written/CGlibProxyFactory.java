package com.chen.written;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理 intercept(Object obj, Method method, Object[] args,MethodProxy
 * proxy) 是CGLib定义的Inerceptor接口的方法，obj表示代理后的子类 ， method为父类方法的反射对象，args为方法的动态入参，
 * 而proxy为代理类实例。一般使用 proxy进行调用父类方法，这样更快。
 */
public class CGlibProxyFactory implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class c) {
		enhancer.setSuperclass(c); // ① 设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create(); // ②通过字节码技术动态创建子类实例
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		checkSecurity();
		arg3.invokeSuper(arg0, arg2);
		return null;
	}

	public void checkSecurity() {
		System.out.println("--------进行安全性检查----------");
	}

}
