package com.avseredyuk.infrastructure;

import com.avseredyuk.repository.Temp;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Anton_Serediuk on 4/5/2017.
 */
public class MyFactoryBean implements FactoryBean<Temp>{

    @Override
    public Temp getObject() throws Exception {
        return new Temp();
    }

    @Override
    public Class<?> getObjectType() {
        return Temp.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
