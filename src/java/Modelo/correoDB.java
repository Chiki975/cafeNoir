/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


 
        

public class correoDB {

public boolean enviarcorreo(String de, String clave,String para,String mensaje,String asunto){
boolean enviado = false;


String host="smtp.gmail.com";

Properties prop=System.getProperties();

prop.put("mail.smtp.starttls.enable","true");
prop.put("mail.smtp.host","host");
prop.put("mail.smtp.user",de);
prop.put("mail.smtp.password",clave);
prop.put("mail.smtp.port",587);
prop.put("mail.smtp.auth","true");
prop.put("mail.smtp.ssl.trust","*");
try{
Session session=Session.getDefaultInstance(prop,null);
MimeMessage message= new MimeMessage(session);

message.setFrom(new InternetAddress(de));

message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
message.setSubject(asunto);
message.setContent(mensaje, "text/html; charset=utf-8");

System.out.print(message);

Transport transport=session.getTransport("smtp");
transport.connect(host,de,clave);

transport.sendMessage(message, message.getAllRecipients());
transport.close();
enviado=true;
System.out.print(enviado);

}catch (Exception e){
e.printStackTrace();
    System.out.println("erroooooooooooooooo");

}
return enviado;

}

}