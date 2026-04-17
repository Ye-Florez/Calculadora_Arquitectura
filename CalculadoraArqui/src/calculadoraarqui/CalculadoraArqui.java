/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoraarqui;

/**
 *
 * @author Yelitz flórez
 */
public class CalculadoraArqui {
    
    String operador1;
    String operador2;
    char operacion;
    int tipoSistema;  //10=Decimal, 2=Binario, 16=Hexa, 8=Octal

    public CalculadoraArqui(){
        
    }
    public CalculadoraArqui(String operador1, String operador2, int tipoSistema, char operacion) {
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.tipoSistema = tipoSistema;
        this.operacion = operacion;
    }
    
    
    public int conversorDecimal(String num, int tipoSistema){
        char [] num2 = num.toCharArray();
        
        int resultado = 0;
        
        for(int i =0; i < num2.length ; i++){
          char n = num2[i];
          int digito = valorDigito(n);
          
          resultado = resultado *tipoSistema + digito;
        }
        
        return resultado;
    } 
    
    
    private int valorDigito(char c){
      if(c >= '0' && c <= '9') return c - '0';
      if(c >= 'A' && c <= 'F') return c - 'A' + 10;
      if(c >= 'a' && c <= 'f') return c - 'a' + 10;
      
      throw new IllegalArgumentException("Dígito inválido: " + c);
    }
 
    private char caracterDigito (int valor){
       if(valor < 10)
           return (char) ('0' + valor);
       
       return (char) ('A' + valor-10);
    }
    
    public String operar(char operacion){
        return;
    }
    
}
