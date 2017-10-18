/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esteban;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author esteban
 */
public class LoggingInterceptor {
   
    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext)throws Exception{
   
        Object interceptedObject = invocationContext.getTarget();
        Method interceptedMethod = invocationContext.getMethod();
    
        System.out.println("Entrando " + interceptedObject.getClass().getName() + "." + interceptedMethod.getName() );
    
        Object o = invocationContext.proceed();
    
        System.out.println("Saliendo " + interceptedObject.getClass().getName() + "." + interceptedMethod.getName() );
        
        return o;
    }
}
