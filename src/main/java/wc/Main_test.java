package wc;

import java.util.Scanner;

public class Main_test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Data_Address dataAddress = new Data_Address();
      //  dataAddress.Insert_Adresses();
      //  dataAddress.DeleteAddress(13);
     //   dataAddress.UpdateAdresses(2);

        Data_Arena dataArena = new Data_Arena();
        dataArena.Insert_Arena();
      //  dataArena.DeleteArena(10);
      //  dataArena.getArena(3);

        Data_Customer dataCustomer = new Data_Customer();
      //  dataCustomer.Insert_Customer();
        dataCustomer.get_Customer(5);

        Data_Consert dataConsert = new Data_Consert();
     //   dataConsert.Insert_Concert();

    }
}
