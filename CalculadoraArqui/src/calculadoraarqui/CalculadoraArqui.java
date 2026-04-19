/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoraarqui;

/**
 *
 * @author Yelitz flórez
 * @author Karol Solano
 */
public class CalculadoraArqui {
    
    String operador1;
    String operador2;
    char [] operaciones = {'+','-','*','/'};
    char operacion;
    int [] tipoSistema = {10, 2, 16, 8};  //10=Decimal, 2=Binario, 16=Hexa, 8=Octal
    int sistema;

    public CalculadoraArqui(){
        
    }
    public CalculadoraArqui(String operador1, String operador2, int sistema, char operacion) {
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.sistema = sistema;
        this.operacion = operacion;
    }
    
    public boolean esSistema(int sistema){
        for(int i=0;i<tipoSistema.length;i++){
            if(tipoSistema[i]==sistema)return true;
        }
        return false;
    }
    
    public boolean esOperacion(char operacion){
        for(int i=0;i<operaciones.length;i++){
            if(operaciones[i]==operacion)return true;
        }
        return false;
    }
    
    public boolean sonDigitosSistema(String num, int tipoSistema){
        char [] n = num.toCharArray();
        
        for(int i=0;i<n.length;i++){
            int digito = valorDigito(n[i]);
            if(tipoSistema==2 && (digito<0 || digito>1))return false;
            else if(tipoSistema==8 && (digito<0 || digito>7))return false;
            else if(tipoSistema==10 && (digito<0 || digito>9))return false;
            else if(tipoSistema==16 && (digito<0 || digito>15))return false;
        }
        
        return true;
    }
    
    public int conversorDecimal(String num, int tipoSistema){
        if(tipoSistema == 10)return Integer.parseInt(num);
        
        char [] num2 = num.toCharArray();
        
        int resultado = 0;
        
        for(int i =0; i < num2.length ; i++){
          char n = num2[i];
          int digito = valorDigito(n);
          
          resultado = resultado *tipoSistema + digito;
        }
        
        return resultado;
    } 
    
    public String conversorBase (int num, int tipoSistema){
        String resultado = "";
        while(num >0){
            int residuo = num % tipoSistema;
            //System.out.println(caracterDigito(residuo));
            resultado = caracterDigito(residuo) + resultado; 
            num = num / tipoSistema;
        }
        return resultado.length() == 0 ? "0" : resultado;
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
         System.out.println("DEBUG - op1: " + operador1 + " op2: " + operador2 + " base: " + sistema);
         
        int a = conversorDecimal(operador1, sistema);
        int b = conversorDecimal(operador2, sistema);
        
        System.out.println("DEBUG - a: " + a + " b: " + b);
        int resultado = 0;
       
        if(operacion == '+') resultado = a + b;
        if(operacion == '-') resultado = a - b;
        if(operacion == '*') resultado = a * b;
        if(operacion == '/') {
            if(b == 0) throw new ArithmeticException("División entre cero");
            resultado = a / b;
        }
        //throw new IllegalArgumentException ("Operación no válida");
        
        return conversorBase(resultado, sistema);
    }
    
}
