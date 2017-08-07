package org.git.chengcheng.life;

import java.util.Date;

public class LifeCalc {

    private Date    startDay          = new Date( );

    private double  storeage          = 10000;

    private double  in                = 8000;
    private double  inUpRateEveryYear = 0.1;

    private boolean isBuyHouse        = true;
    private Date    hasChildDate      = null;

    public double getStoreage( ) {
        return storeage;
    }

    public void setStoreage( double storeage ) {
        this.storeage = storeage;
    }

    public boolean isBuyHouse( ) {
        return isBuyHouse;
    }

    public void setBuyHouse( boolean isBuyHouse ) {
        this.isBuyHouse = isBuyHouse;
    }

    public Date getHasChildDate( ) {
        return hasChildDate;
    }

    public void setHasChildDate( Date hasChildDate ) {
        this.hasChildDate = hasChildDate;
    }

    public double later( int years ) {
        int days = 365 * years;
        for ( int i = 0; i < days; i++ ) {

        }
        return .0;
    }

    public static void main( String[ ] args ) {
        LifeCalc lc = new LifeCalc( );
        Date startDay = new Date( );
        System.out.println( startDay.toString( ) );
    }
}
