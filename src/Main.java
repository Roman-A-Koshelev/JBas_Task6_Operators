// Конвертер физических величин

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Конвертер физических величин.");

        final int CONV_WEIGHT = 1;
        final int CONV_DISTANCE = 2;
        System.out.println("Выберите что переводить: 1 - масса, 2 - расстояние:");
        int par = in.nextInt();

        System.out.print("Выберите единицу измерения: ");
        switch(par) {
        case CONV_WEIGHT:
            System.out.println("1 - килограмм, 2 - фунт, 3 - унция");
            break;
        case CONV_DISTANCE:
            System.out.println("1 - метр, 2 - миля, 3 - ярд, 4 - фут");
            break;
        default:
            System.out.println("Выбранная физическая величина (\"" + par + "\") не поддерживается!");
            return;
        }
        int unit = in.nextInt();

        System.out.println("Введите количество выбранных единиц:");
        int val = in.nextInt();

        switch(par) {
        case CONV_WEIGHT:    convWeight(unit, val); break;
        case CONV_DISTANCE:  convDist  (unit, val); break;
        default:
            System.out.println("Выбранная физическая величина (\"" + par + "\") не поддерживается!");
            return;
        }
    }

    // Коневертер Массы
    static void convWeight(int conv_unit, double val) {
        final int UNIT_KG = 1; // Килограмм
        final int UNIT_LB = 2; // Фунт
        final int UNIT_OZ = 3; // Унция
        final int UNIT_MIN = UNIT_KG;
        final int UNIT_MAX = UNIT_OZ;

        if (conv_unit < UNIT_MIN || UNIT_MAX < conv_unit) {
            System.out.println("Выбранная единица измерения (\"" + conv_unit + "\") не поддерживается!");
            return;
        }

        final double[][] weight_coef = {
            // KG       LB      OZ
            {  1,       2.205,  35.27}  // KG
            , {0.4536,  1,      16}     // LB
            , {0.02835, 0.0625, 1}      // OZ
        };

        final String[] unit_names = {"Килограммы", "Фунты", "Унции"};

        for (int cur_unit = 0; cur_unit < UNIT_MAX; ++cur_unit) {
            System.out.printf("%s:\t%.3f\n", unit_names[cur_unit], weight_coef[conv_unit - 1][cur_unit] * val);
        }
    }

    // Коневертер Расстояния
    static void convDist(int conv_unit, double val) {
        final int UNIT_M  = 1; // Метр
        final int UNIT_MI = 2; // Миля
        final int UNIT_YD = 3; // Ярд
        final int UNIT_FT = 4; // Фут
        final int UNIT_MIN = UNIT_M;
        final int UNIT_MAX = UNIT_FT;

        if (conv_unit < UNIT_MIN || UNIT_MAX < conv_unit) {
            System.out.println("Выбранная единица измерения (\"" + conv_unit + "\") не поддерживается!");
            return;
        }

        final double[][] dist_coef = {
                // M        MI          YD      FT
                {  1,       0.0006214,  1.094,  3.281}  // M
                , {1609,    1,          1760,   5280}   // MI
                , {0.9144,  0.0005682,  1,      3}      // YD
                , {0.3048,  0.0001894,  0.3333, 1}      // FT
        };

        final String[] unit_names = {"Метры", "Мили", "Ярды", "Футы"};

        for (int cur_unit = 0; cur_unit < UNIT_MAX; ++cur_unit) {
            System.out.printf("%s:\t%.3f\n", unit_names[cur_unit], dist_coef[conv_unit - 1][cur_unit] * val);
        }
    }
}