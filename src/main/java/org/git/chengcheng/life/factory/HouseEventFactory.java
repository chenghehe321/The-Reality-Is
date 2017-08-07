package org.git.chengcheng.life.factory;

import java.util.Date;
import java.util.List;

import org.git.chengcheng.life.LifeConfig;

public class HouseEventFactory extends EventFactory {

    private LifeConfig config;
    private Date       baseDay;

    public HouseEventFactory( LifeConfig config, Date baseDay ) {
        super( );
        this.config = config;
        this.baseDay = baseDay;
    }

    @Override
    public List< LifeEvent > getEvents( Date targetDate ) {

        return null;
    }

}
