package Practica_evaluacion.Utils;

/**
 * Clase para las validaciones
 *
 * @author Sergio Manresa
 * @version 1.0
 * @since 11/01/2023
 */
public class Validaciones {

    /**
     * Comprueba que el dni es válido usando las siguientes validaciones:
     * - Longitud de 9 caracteres
     * - 8 primeros caracteres han de ser numeros y el ultimo una letra en mayuscula
     * @param dni
     * @return dni valido
     */

    public static boolean dni(String dni){
        //la longitud de un DNI siempre es de 9 caracteres
        if(dni.length()!=9){
            System.out.println("longitud inválida");
            return false;
        }
        //Comprueba que los 8 primeros digitos son numeros
        for(int i=0; i<dni.length()-1;i++){
            if(dni.charAt(i)<'0' ||dni.charAt(i)>'9'){
                System.out.println("No se aceptan caracteres que no sean numeros");
                return false;
            }
        }
        //Se comprueba la letra del final
        if(dni.charAt(dni.length()-1)<'A'|| dni.charAt(dni.length()-1)>'Z'){
            System.out.println("Falta la letra final");
            return false;
        }
        else{
            int resultadoCalculo = Integer.parseInt(dni.substring(0, dni.length()-1))%23;
            if(resultadoCalculo==0) return dni.charAt(dni.length()-1)=='T';
            else if(resultadoCalculo==1) return dni.charAt(dni.length()-1)=='R';
            else if(resultadoCalculo==2) return dni.charAt(dni.length()-1)=='W';
            else if(resultadoCalculo==3) return dni.charAt(dni.length()-1)=='A';
            else if(resultadoCalculo==4) return dni.charAt(dni.length()-1)=='G';
            else if(resultadoCalculo==5) return dni.charAt(dni.length()-1)=='M';
            else if(resultadoCalculo==6) return dni.charAt(dni.length()-1)=='Y';
            else if(resultadoCalculo==7) return dni.charAt(dni.length()-1)=='F';
            else if(resultadoCalculo==8) return dni.charAt(dni.length()-1)=='P';
            else if(resultadoCalculo==9) return dni.charAt(dni.length()-1)=='D';
            else if(resultadoCalculo==10) return dni.charAt(dni.length()-1)=='X';
            else if(resultadoCalculo==11) return dni.charAt(dni.length()-1)=='B';
            else if(resultadoCalculo==12) return dni.charAt(dni.length()-1)=='N';
            else if(resultadoCalculo==13) return dni.charAt(dni.length()-1)=='J';
            else if(resultadoCalculo==14) return dni.charAt(dni.length()-1)=='Z';
            else if(resultadoCalculo==15) return dni.charAt(dni.length()-1)=='S';
            else if(resultadoCalculo==16) return dni.charAt(dni.length()-1)=='Q';
            else if(resultadoCalculo==17) return dni.charAt(dni.length()-1)=='V';
            else if(resultadoCalculo==18) return dni.charAt(dni.length()-1)=='H';
            else if(resultadoCalculo==19) return dni.charAt(dni.length()-1)=='L';
            else if(resultadoCalculo==20) return dni.charAt(dni.length()-1)=='C';
            else if(resultadoCalculo==21) return dni.charAt(dni.length()-1)=='K';
            else if(resultadoCalculo==23) return dni.charAt(dni.length()-1)=='E';
        }
        return true;
    }

    private static int[]fecha= new int[6];

    /**
     * esta function se encarga de distinguir los tipos de tarjeta
     * @param tarjeta
     */
    public static void tipo_tarjeta(String tarjeta){
        int primer_digito = Integer.parseInt(tarjeta.substring(0, 1));
        int segundo_digito = Integer.parseInt(tarjeta.substring(1, 2));
        if (primer_digito == 4) {
            System.out.println("Esta tarjeta es una tarjeta Visa");
        } else if (primer_digito == 5 && (segundo_digito >= 1 && segundo_digito <= 5)) {
            System.out.println("Esta tarjeta es una tarjeta MasterCard");
        } else if (primer_digito == 3 && (segundo_digito == 4 || segundo_digito == 7)) {
            System.out.println("Esta tarjeta es una tarjeta American Express");
        } else if (primer_digito == 3 && (segundo_digito == 0 || segundo_digito == 6 || segundo_digito ==8)) {
            System.out.println("Esta tarjeta es una tarjeta Diners Club");
        } else {
            System.out.println("Este tipo de tarjeta no está soportado");
        }

    }

    /**
     * esta función se encarga de verificar la tarjeta
     * @param tarjeta
     * @return tarjeta valida
     */
    public static boolean validación_tarjeta(String tarjeta){
        int sum=0;
        boolean alternative=false;
        for (int i = tarjeta.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(tarjeta.substring(i, i + 1));
            if (alternative) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternative = !alternative;
        }
        return (sum % 10 == 0);
    }
    /**
     * esta función se encarga de verificar que el string no contenga nada que no sea un numero
     * @param personas
     * @return un string de que contiene solo números
     */
    public static boolean solo_numero(String personas){
        for (int i = 0; i < personas.length(); i++) {
            if (personas.charAt(i)<'0'|| personas.charAt(i)>'9'){

                return false;
            }
        }
        return true;
    }

    /**
     * Esta función se encarga de saber si el email usado a la hora de iniciarse sesión sea el mismo que se usó a la hora de registrarse y pasa lo mismo
     *     con el código de control.
     * @param email,
     * @param control,
     * @param email_usuario,
     * @return que el email del login sea igual al del registro y lo mismo con el codigo
     */

    public static boolean igual(String email,String control,String email_usuario,String codigo_usuario ){
        return email.equals(email_usuario) && control.equals(codigo_usuario);
    }

    /**
     * esta función sirve para que de error cuando dejemos en blanco el String
     * @param palabra
     * @return la longitud de la palabra
     */

    public static boolean noTieneNada(String palabra) {return palabra.length() == 0;}

    /**
     * esta función sirve para obtener el código de control
     * @param control
     * @return el codigo
     */

    public static String primera_letra(String control){
        //máximo tres espacios
        int contadorEspacios = 0;
        String mayusculas = "";
        String ultimasLetras = "";
        int codigoNum = 0;
        String codigo;
        control = control.trim();

        //Le agrego un espacio al final para facilitar el check
        for(int i = 0; i < control.length(); i++){
            if(control.charAt(i)==' ')
                contadorEspacios++;
        }
        //aquí ponemos el máximo de espacios
        if(contadorEspacios!=3){
            System.out.println("es un espacio por palabra máximo=3");
            return "ERROR";
        }
        mayusculas+=control.charAt(0);
        for(int i = 0; i < control.length(); i++){
            if(control.charAt(i)==' '){
                ultimasLetras+=""+control.charAt(i-1);
                if(i+1!=control.length()){
                    mayusculas+=""+control.charAt(i+1);
                }
            }
        }
        for(int i = 0; i<ultimasLetras.length(); i++){
            codigoNum += ultimasLetras.charAt(i);
        }
        codigo = mayusculas+(codigoNum/4 - codigoNum%4);
        codigo = codigo.toUpperCase();
        return codigo;
    }

    /**
     * Esta funcion se encarga de comprobar si la fecha es correcta
     * @param date
     * @return la fecha correcta
     */

    public static boolean fechaCorrecta(String date){
        int mes, anyo, dias;
        boolean bisiesto = false;
        date = date.trim();
//aquí ponemos la longitud maxima de la fecha
        if(date.length()!=10){
            System.out.println("Longitud no permitida");
            return false;
        }
//aquí ponemos los símbolos aceptados para la fecha
        if((date.charAt(2)!='/' || date.charAt(5)!='/') && (date.charAt(2)!='-' || date.charAt(5)!='-')){
            System.out.println("formato no valido");
            return false;
        }
//aquí se asegura de que no hayan cosas que no sean números
        for(int i = 0; i < 2; i++){
            if(date.charAt(i) < '0' || date.charAt(i) > '9' ){
                System.out.println("solo se permiten números");
                return false;
            }
        }
//aquí se asegura de que no hayan cosas que no sean números en el dia
        dias = Integer.parseInt(date.substring(0, 2));
        for(int i = 3; i < 5; i++){
            if(date.charAt(i) < '0' || date.charAt(i) > '9' ){
                System.out.println("No hay números permitidos en el dia");
                return false;
            }
        }
//aquí se asegura de que no hayan cosas que no sean números en el mes
        mes = Integer.parseInt(date.substring(3, 5));
        for(int i = 6; i < 10; i++){
            if(date.charAt(i) < '0' || date.charAt(i) > '9' ){
                System.out.println("No hay números permitidos en el mes");
                return false;
            }
        }
//aquí nos aseguramos que el año sea bisiesto o no y que en los respectivos meses tengan 31 dias como máximo
        anyo = Integer.parseInt(date.substring(6, 10));
        if((anyo%4==0 && anyo%100!=0) || anyo%400==0)
            bisiesto = true;
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            if(dias > 31 || dias <= 0){
                System.out.println("Error con los dias");
                return false;
            }
        }
//aquí se asegura de que en los meses de abajo los dias máximo son 30
        else if(mes==4||mes==6||mes==9||mes==11){
            if(dias>30 || dias <= 0){
                System.out.println("Error con los dias");
                return false;
            }
        }
//y ahora se encarga de poner en febrero como máximo 28 dias excepto cuando sea bisiesto
        else if(mes==2){
            if(bisiesto){
                if(dias>29 || dias <= 0){
                    System.out.println("Error en los dias ");
                    return false;
                }
            }

            else{
                if(dias>28 || dias <= 0){
                    System.out.println("Error con los dias");
                    return false;
                }
            }
        }
//aquí se pone el rango aceptado de los años
        if(anyo<1910 ||anyo>2023){
            System.out.println("No se acepta ese año");
            return false;
        }
//aquí me aseguro de que no seas menor
        if(2023-anyo < 18){
            System.out.println("Eres menor de edad");
            return false;
        }
// y aquí nos aseguramos de los rangos de los meses
        if(mes < 0 || mes > 12){
            System.out.println("error en los meses");
            return false;
        }

        return dias>0 && anyo>0 && mes>0;
    }

    /**
     * Esta función sirve para verificar que la fecha de entrada sea menor que la de salida
     * @param fecha_entrada
     * @param fecha_salida
     * @return la fecha comparada
     */
    public static boolean comprobar_fecha_entrada_salida(String fecha_entrada,String fecha_salida){
        if (!fechaentrada_salida(fecha_entrada) && !fechaentrada_salida(fecha_salida)){
            System.out.printf("  la fecha esta mal \n");
            return false;
        }
        fechaentrada_salida(fecha_entrada);
        int anyo = fecha[0];
        int mes = fecha[1];
        int dias = fecha[2];
        fechaentrada_salida(fecha_salida);
        int anyoSalida = fecha[0];
        int mesSalida = fecha[1];
        int diasSalida = fecha[2];


        if(anyoSalida < anyo){
            System.out.println(anyoSalida+"Este es el año de salida");
            System.out.println(anyo+"Este es el año de entrada");
            System.out.println("El año de salida es menor");
            return false;
        }
        if(anyo==anyoSalida && mes > mesSalida){
            System.out.println("error en el mes");
            return false;
        }
        if((mes==mesSalida && anyo==anyoSalida)&&dias>=diasSalida){
            System.out.println("error en el dia");
            return false;
        }
        return true;
    }

    /**
     * esta funcion se encarga de validar la fecha de entrada
     * @param fecha_entrada
     * @return de la fecha de entrada salida correctamente
     */
    public static boolean fechaentrada_salida(String fecha_entrada){
        int mes, anyo, dias;
        boolean bisiesto = false;
        fecha_entrada = fecha_entrada.trim();
//aquí ponemos la longitud maxima de la fecha
        if(fecha_entrada.length()!=10){
            System.out.println("Longitud no permitida");
            return false;
        }
//aquí ponemos los símbolos aceptados para la fecha
        if((fecha_entrada.charAt(2)!='/' || fecha_entrada.charAt(5)!='/') && (fecha_entrada.charAt(2)!='-' || fecha_entrada.charAt(5)!='-')){
            System.out.println("formato no valido");
            return false;
        }
//aquí se asegura de que no hayan cosas que no sean números
        for(int i = 0; i < 2; i++){
            if(fecha_entrada.charAt(i) < '0' || fecha_entrada.charAt(i) > '9' ){
                System.out.println("solo se permiten números");
                return false;
            }
        }
//aquí se asegura de que no hayan cosas que no sean números en el dia
        dias = Integer.parseInt(fecha_entrada.substring(0, 2));
        for(int i = 3; i < 5; i++){
                if(fecha_entrada.charAt(i) < '0' || fecha_entrada.charAt(i) > '9' ){
                System.out.println("No hay números permitidos en el dia");
                return false;
            }
        }
//aquí se asegura de que no hayan cosas que no sean números en el mes
        mes = Integer.parseInt(fecha_entrada.substring(3, 5));
        for(int i = 6; i < 10; i++){
            if(fecha_entrada.charAt(i) < '0' || fecha_entrada.charAt(i) > '9' ){
                System.out.println("No hay números permitidos en el mes");
                return false;
            }
        }
//aquí nos aseguramos que el año sea bisiesto o no y que en los respectivos meses tengan 31 dias como máximo
        anyo = Integer.parseInt(fecha_entrada.substring(6, 10));
        if((anyo%4==0 && anyo%100!=0) || anyo%400==0)
            bisiesto = true;
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
            if(dias > 31 || dias <= 0){
                System.out.println("Error con los dias");
                return false;
            }
        }
//aquí se asegura de que en los meses de abajo los dias máximo son 30
        else if(mes==4||mes==6||mes==9||mes==11){
            if(dias>30 || dias <= 0){
                System.out.println("Error con los dias");
                return false;
            }
        }
//y ahora se encarga de poner en febrero como máximo 28 dias excepto cuando sea bisiesto
        else if(mes==2){
            if(bisiesto){
                if(dias>29 || dias <= 0){
                    System.out.println("Error en los dias ");
                    return false;
                }
            }

            else{
                if(dias>28 || dias <= 0){
                    System.out.println("Error con los dias");
                    return false;
                }
            }
        }
//aquí se pone el rango aceptado de los años
        if(anyo<2023 ||anyo>2040){
            System.out.println("No se acepta ese año");
            return false;
        }
// y aquí nos aseguramos de los rangos de los meses
        if(mes < 0 || mes > 12){
            System.out.println("error en los meses");
            return false;
        }
//aquí fija el contenido del array a los días, meses y años

        if(fecha[0]==0){
            fecha[0] = anyo;
            fecha[1] = mes;
            fecha[2] = dias;
        }
        else{
            if(fecha[3]!=0){
                fecha[0] = anyo;
                fecha[1] = mes;
                fecha[2] = dias;
            }else{
                fecha[3] = anyo;
                fecha[4] = mes;
                fecha[5] = dias;
            }
        }

        return dias>0 && anyo>0 && mes>0;
    }

    /**
     * esta función se encarga de comprobar si el nombre y el apellido sean correctos
     * @param frase
     * @param apellido
     * @return nombre correcto
     */
    public static boolean nombrecorrecto(String frase, boolean apellido){

        frase = frase.trim();
        frase = frase.toUpperCase();
        int contadorEspacios = 0;
        if(frase.length()==0){
            System.out.println("No se puede dejar vacío");
            return false;
        }
        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) < 'Á' || frase.charAt(i) > 'Ú'){
                if((frase.charAt(i) != 'Ç' || frase.charAt(i) != 'Ñ')){
                    if(frase.charAt(i) < 'A' || frase.charAt(i) > 'Z' ){
                        if(frase.charAt(i)==' '){
                            contadorEspacios+=1;
                        }
                        else{
                            if(apellido)
                                System.out.println("Error en el apellido ");
                            else
                                System.out.println("Error en el nombre");
                            return false;
                        }
                    }
                }
            }
        }
        //Aunque se acepten espacios, no pueden ser solo espacios el string
        return contadorEspacios!=frase.length();
    }

    /**
     * esta funcion verifica el correo
     * @param email
     * @return email correcto
     */
    public static boolean emailcorrecto(String email){
        email = email.trim();
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i)==' ')
                return false;
        }
        int posPunto;
        //La arroba no puede estar al final del string u ocupar menos de 3 espacios (Recordemos que hay que comprobar las extensiones)
        //aquí se asegura que no haya dos @ seguidas.
        int pos_a = email.indexOf('@');
        int contA = 0;
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i)=='@'){
                contA++;
            }
        }
//aquí nos aseguramos de que no pongas dos @ seguidos
        if(contA != 1){
            System.out.println("no pongas dos arrobas seguidos");
            return false;
        }

        //esta función sirve para que no dejes en blanco lo de antes del @
        if(pos_a==0 || pos_a==-1){
            System.out.println("No se acepta ese formato de correo");
            return false;
        }

        if(email.charAt(pos_a+1)=='.')
            return false;
//aquí nos aseguramos de que el punto no sea el primero
        String subEmail = email.substring(pos_a);
        if(subEmail.indexOf('.')==-1){
            System.out.println("correo no valido");
            return false;
        }
//aquí nos aseguramos de que contengan las extensiones
        posPunto = subEmail.indexOf('.');
        String extension = subEmail.substring(posPunto+1);
        if (!extension.equals("com") && !extension.equals("es") && !extension.equals("org")){
            System.out.println("extension no valida");
            return false;
        }
        return true;

    }
    //comprueba que la frase está bien y lo encripta

    /**
     * se encarga de verificar el número de teléfono diferenciando entre teléfono fijo o no
     * @param telefono
     * @return numero correcto
     */

    public static boolean numerocorrecto(String telefono){
        telefono = telefono.trim();
        telefono = telefono.replaceAll("\\s", "");
        boolean fijo = true, movil = true;
        if(telefono.length()!=9){
            System.out.println("numero no válido");
            return false;
        }
//aquí nos aseguramos que solo haya números
        for(int i = 0; i < telefono.length(); i++){
            if(telefono.charAt(i) < '0' || telefono.charAt(i) > '9') {
                System.out.println("Solo acepta números");
                return false;
            }
        }
//aquí nos aseguramos de que empiecen por 9,8,6,7 y dependiendo sera fijo o no
        if(telefono.charAt(0) == '9' || telefono.charAt(0) == '8'){
            movil = true;
        }
        else if(telefono.charAt(0) == '6' || telefono.charAt(0) == '7'){
            fijo = true;
        }
        else{
            movil = false;
            fijo = false;
            System.out.println("este numero no es correcto");
        }
        return movil || fijo;
    }

    /**
     * Esta función se encarga de verificar que todas las anteriores validaciones sean correctas
     * @param nombre
     * @param apellidos
     * @param email
     * @param telefono
     * @param fecha
     * @param control
     * @return todos los datos correctamente
     */
    public static boolean comprobarentradas(String nombre, String apellidos, String email, String telefono, String fecha, String control) {
        return nombrecorrecto(nombre,false) && nombrecorrecto(apellidos,true) && emailcorrecto(email) && numerocorrecto(telefono) && fechaCorrecta(fecha);
    }
}
