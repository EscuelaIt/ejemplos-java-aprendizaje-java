package es.usantatecla.a3_numbers.a4_validation.v0_0;

import es.usantatecla.utils.Console;

public class App {

  public static void main(String[] args) {
    Console console = new Console();
    final int MIN = 1;
    final int MAX = 10;
    final String INTERVAL = "[" + MIN + ", "+ MAX +"]";
    int input;
    boolean error;
    do {
      input = console.readInt("Dame un valor en el intervalo " + INTERVAL + ": ");
      error = input < MIN || MAX < input;
      if (error) //{
        console.writeln("Error!!! No está dentro del intervalo " + INTERVAL + " ! 8-o");
      //}
    } while(error);
    console.writeln("Gracias!!! Has escogido el " + input);
  }
}

