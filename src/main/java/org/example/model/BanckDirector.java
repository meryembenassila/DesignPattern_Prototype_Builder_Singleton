package org.example.model;

public class BanckDirector {
   // c'est une classe pour centraliser les builder '
    public static BanckAccount.BanckAccountBuilder accountbuilder(){
        return new BanckAccount.BanckAccountBuilder();
    }
}
