package org.git.chengcheng.life.factory;

import java.util.Date;
import java.util.List;

public abstract class EventFactory {
    public abstract List< LifeEvent > getEvents( Date targetDate );
}
