package com.company;

import clases.CapacidadEndedudamiento;
import clases.Messages;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CapacidadEndedudamiento endeudamiento = new CapacidadEndedudamiento();
        String entrada = "SI";

        try {
            while (entrada.equalsIgnoreCase("si")) {
                /*----------------------------------------------------------*/
                boolean isNumeric = false;
                String message_when_error = "";

                System.out.println(Messages.IngMensuales);
                String str_ingMesuales = scanner.nextLine();
                isNumeric = isNumeric(str_ingMesuales);

                String str_gastoFijo="";
                if(isNumeric) {
                    System.out.println(Messages.GastoFijo);
                    str_gastoFijo = scanner.nextLine();
                    isNumeric = isNumeric(str_gastoFijo);
                }

                String str_gastovariable="";
                if(isNumeric) {
                    System.out.println(Messages.GastoVariable);
                    str_gastovariable= scanner.nextLine();
                    isNumeric = isNumeric(str_gastovariable);
                }

                /*---------------------------------------------------------*/
                if (isNumeric) {
                    int ingMesuales = Integer.parseInt(str_ingMesuales);
                    int gastoFijo = Integer.parseInt(str_gastoFijo);
                    int gastovariable = Integer.parseInt(str_gastovariable);

                    endeudamiento.setIngresosTotales(ingMesuales);
                    endeudamiento.setGastosFijos(gastoFijo);
                    endeudamiento.setGastoVaribales(gastovariable);
                    double capacidadEndeudamiento = endeudamiento.getCapacidadEndeudamiento(ingMesuales, gastoFijo, gastovariable);

                    System.out.println(Messages.CapacidadEndeudamiento + capacidadEndeudamiento);
                }
                else
                {
                    System.out.println(Messages.DatoIncorrecto);
                }

                System.out.println(Messages.VolverCalcular);
                entrada = scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println(Messages.ErrorInesperado);
        }
    }

    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
