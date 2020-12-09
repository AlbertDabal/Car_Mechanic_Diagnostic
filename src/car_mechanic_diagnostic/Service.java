/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_mechanic_diagnostic;

/**
 *
 * @author Albert
 */
//Dziedzczenie
public class Service {

    Service() {

    }

    public int olej = 15000;
    public int filtr_paliwa = 20000;
    public int filtr_powietrza = 25000;
    public int tarcze = 40000;

}

class Diesel extends Service {

    Diesel() {

    }
    public int dwumasa = 150000;

}

class Gasoline extends Service {

    Gasoline() {

    }

}
