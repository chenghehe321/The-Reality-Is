package org.git.chengcheng.life;

public class LifeCalc {

    public static void main( String[ ] args ) {
        boolean houseFlag = true;       // 是否买房
        boolean carFlag = true;         // 是否买车
        boolean carDoneFlag = false;
        double storage = 150000;        // 初始存款
        double taxRate = 0.667;         // 工资上税
        double in = 13000;              // 工资
        double in_rate = 0.05;          // 工资年平均上浮比例
        int house = 3000;               // 每月房子开销
        int car = 0;                    // 每月车开销
        int year = 10;                  // 预测年数
        int days = 365 * year;          // 预测天数
        int carDay = 0;                 // 买车日
        double yearInvest = 0.05;       // 投资年化
        double invest = storage * 0.5;  // 投资占存款比例
        storage = storage - invest;
        double allin = 0, allinvest = 0;
        double inhand = 50000;          // 保持在手里不投资的存款
        double gjj_rate = 0.12;         // 公积金比例
        int childyear = 1;              // 过几年要娃
        for ( int i = 0; i < days; i++ ) {
            if ( storage <= 0 ) {
                System.out.println( "破产日:[" + i + "," + ( ( double ) i / 365 ) + "年], 税前工资[" + in + "], 手里有[" + storage
                        + "], 投资账户有[" + invest + "]" );
                break;
            }
            if ( storage < 20000 ) {// 保底存款两万，小于两万不投资
                invest = 0;
                storage += invest;
            }
            if ( i % 365 == 0 && i != 0 ) {
                in = in * ( 1 + in_rate );
                double profit = invest * yearInvest;
                allinvest += profit;
                invest += profit;
                if ( invest == 0 && storage >= 20000 ) {// 如果没有投资，就用存款的一半用作投资
                    invest = storage / 2;
                    storage = storage / 2;
                }
                if ( storage > inhand ) {// 手头存款保持五万，其他用作投资
                    double delta = storage - inhand;
                    storage = inhand;
                    invest += delta;
                }

                // allin += invest;
                // storage += invest;
                storage += ( 2 * in );
            }
            if ( i % 30 == 0 && i != 0 ) {
                double afterTax = in * taxRate; // 五险一金个税
                afterTax += ( 2 * in * gjj_rate );// 加上个人与公司部分的公积金
                storage += afterTax;
                storage += 5000;// 老婆工资
                allin += afterTax;
                storage -= house;
                // storage -= 2000;// 外地房租
                storage -= car;
            }

            if ( storage + invest > 200000 && carFlag ) {
                System.out.println( "买车日:[" + i + "," + ( ( double ) i / 365 ) + "年], 税前工资[" + in + "], 手里有[" + storage
                        + "], 投资账户有[" + invest + "]" );
                carDay = i;
                storage += invest;
                invest = 0;
                storage -= 100000;// 车首付
                car += 2000; // 日常费用
                car += 5000; // 车贷
                carFlag = false;
            }

            // 总存款达到40W时，卖了现在的房子换大房子
            if ( storage + invest > 400000 && houseFlag ) {
                storage += 1000000;
                System.out.println( "买房日:[" + i + "," + ( ( double ) i / 365 ) + "年], 税前工资[" + in + "], 手里有[" + storage
                        + "], 投资账户有[" + invest + "]" );
                storage += invest;
                invest = 0;
                storage -= 1000000;// 首付
                house += 8000;
                houseFlag = false;
            }

            if ( !carFlag && i - carDay > 365 * 3 && !carDoneFlag ) {
                System.out.println( "车贷还完日:[" + i + "," + ( ( double ) i / 365 ) + "年], 税前工资[" + in + "], 手里有["
                        + storage + "], 投资账户有[" + invest + "]" );
                car -= 5000;
                carDoneFlag = true;
            }

            if ( carFlag ) {
                storage -= 40; // 如果没买车有交通开销
            }
            storage -= 80; // 日饮食开销
            storage -= 45; // 人情开销

            // 娃相关开销
            // 产前一年每日花费
            if ( i > childyear * 365 && i < ( childyear + 1 ) * 365 ) {
                storage -= 100;
            }
            // 生产花费
            if ( i == childyear * 365 ) {
                storage -= 20000;
            }
            // 产后一年每月花费
            if ( i > ( childyear + 1 ) * 365 && i < 365 * ( childyear + 2 ) && i % 30 == 0 ) {
                storage -= 2000;
            }
            // 教育每月花费
            if ( i > 365 * ( childyear + 2 ) && i % 30 == 0 ) {
                storage -= 1000;
            }
            // System.out.println( storage + invest );
        }
        System.out.println( "总收入:" + allin + ", 总投资收益:" + allinvest );
    }
}
