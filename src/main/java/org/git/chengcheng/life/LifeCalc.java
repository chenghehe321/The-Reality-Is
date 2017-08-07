package org.git.chengcheng.life;

public class LifeCalc {

    public static void main( String[ ] args ) {
        boolean houseFlag = true;
        boolean carFlag = true;
        boolean carDoneFlag = false;
        double storage = 100000;
        double taxRate = 0.667;
        double in = 5000;
        double in_rate = 0.1;
        int house = 2000;
        int car = 2000;
        int year = 10;
        int days = 365 * year;
        int carDay = 0;
        double yearInvest = 0.05;
        double invest = storage * 0.1;
        double allin = 0;
        for ( int i = 0; i < days; i++ ) {
            if ( i % 365 == 0 ) {
                in = in * ( 1 + in_rate );
                invest += ( invest * yearInvest );
                // allin += invest;
                // storage += invest;
                storage += ( 2 * in );
            }
            if ( i % 30 == 0 ) {
                double afterTax = in * taxRate;
                storage += afterTax;
                storage += 5000;
                allin += afterTax;
                storage -= house;
                // storage -= 2000;
                storage -= car;
            }
            if ( storage > 600000 && houseFlag ) {
                System.out.println( "income:" + in );
                storage -= 500000;
                house += 5000;
                houseFlag = false;
            }

            if ( storage > 150000 && carFlag ) {
                carDay = i;
                storage -= 100000;
                storage += 50000;
                car += 500;
                car += 4000;
                carFlag = false;
            }
            if ( !carFlag && i - carDay > 365 * 3 && !carDoneFlag ) {
                car -= 4000;
                carDoneFlag = true;
            }
            storage -= 80;
            storage -= 38;
            storage -= 40;
            if ( i > 0 && i < 365 ) {
                storage -= 100;
            }
            if ( i == 365 ) {
                storage -= 20000;
            }
            if ( i > 365 && i < 365 * 2 && i % 30 == 0 ) {
                storage -= 2000;
            }
            if ( i > 365 * 2 && i % 30 == 0 ) {
                storage -= 1000;
            }
            System.out.println( storage );
        }
        // System.out.println( allin );
    }
}
