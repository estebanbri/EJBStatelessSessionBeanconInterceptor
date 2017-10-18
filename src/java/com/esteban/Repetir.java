/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esteban;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

/**
 *
 * @author esteban
 */
@Stateless
public class Repetir implements RepetirRemote {

    @Interceptors(LoggingInterceptor.class)
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public String repetir(String repitiendo) {
        return "Repitiendo: " + repitiendo;
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Schedule(hour = "*", minute = "*",second = "*/30")
    @Override
    public void logMessage() {
        System.out.println("Mensaje Log() metodo invocado a las:" + new Date(System.currentTimeMillis()));
    }
    
}
