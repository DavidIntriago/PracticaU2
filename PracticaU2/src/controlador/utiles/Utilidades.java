/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Usuario
 */
public class Utilidades {
    public static String capitalizar(String nombre){
        char[] aux =nombre.toCharArray();
        aux[0]=Character.toUpperCase(aux[0]);
        return new String(aux);
    }
    public static Field obtenerAtributo(Class clase, String nombre){
        Field atributo= null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo=aux;
                break;
            }
        }
        return atributo;
    }
    
    public static Object transformarDato(Field atributo, String dato){
        Object transformar=null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
            if (atributo.getType().getSimpleName().equals("Integer")){
                transformar=Integer.parseInt(dato);
            }else{
                transformar=dato;
            }
        }
        return dato;
    }
    
        
    public static String encriptar(String dato){
        return Base64.getEncoder().encodeToString(dato.getBytes());
    }
    
    public static String desencriptar(String dato){
        return new String(Base64.getDecoder().decode(dato));
    }
    
    // ----------------OTRA FORMA--------------

    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        byte[] claveEncription=clave.getBytes("UTF-8");
//        MessageDigest sha=MessageDigest.getInstance("SHA-1");
//      claveEncription=sha.digest(claveEncription);
        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec=new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }
    
    public static String encriptarClave(final String datos, final String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        byte[] decodeKey=Base64.getDecoder().decode(claveSecreta);
        SecretKeySpec secretKeySpec=crearClave(new String(decodeKey));
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        
//        byte[] datosEncriptar= datos.getBytes("UTF-8");
        byte[] bytesEncriptados=cipher.doFinal(datos.getBytes("UTF-8"));
//        String encriptado=encriptar(new String(bytesEncriptados));
        
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }
    
    public static String decencriptarClave(final String datos,final String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        byte[] decodeKey= Base64.getDecoder().decode(claveSecreta);
        SecretKeySpec secretKeySpec=crearClave(new String(decodeKey));
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        
        byte[] bytesEncriptados = Base64.getDecoder().decode(datos); //desencriptar(datos).getBytes();
        byte[] datosDesencriptados= cipher.doFinal(bytesEncriptados);
        return new String(datosDesencriptados);
        
    }
    public static Boolean isFloat(Class clase){
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Float");
    }
    public static Boolean isNumbre(Class clase){
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    public static Boolean isString(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    public static Boolean isCharacter(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }
    public static Boolean isBoolean(Class clase){
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    public static Boolean isPrimitive(Class clase){
        return clase.isPrimitive();
    }
    public static Boolean isObject(Class clase){
        return (!isPrimitive(clase)&&!isBoolean(clase)&& !isCharacter(clase)&&!isString(clase)&&!isNumbre(clase));
    }
    public static void main(String[] args) {
//        System.out.println(Utilidades.decencriptarClave(datos, claveSecreta));
        try {
//            System.out.println(Utilidades.encriptarClave("Lukas", "ABC123"));
            System.out.println(Utilidades.decencriptarClave("Ygk+QoHxv4frPmkJAnWKrg==", "ABC123"));
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    
}
//google add