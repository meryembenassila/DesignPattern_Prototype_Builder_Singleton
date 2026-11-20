package org.example;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BanckAccount;
import org.example.model.Customer;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {

        //pour copier un objet
        //1. sans prototype
        BanckAccount account1=new BanckAccount();
        account1.setAccountId(1L);
        account1.setCurrency("MAD");
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.ACTIVATED);
        Customer customer1 = new Customer(1L, "Meryem", "meryem@gmail.com");
        account1.setCustomer(customer1);
       //1. sans prototype
        BanckAccount account2=new BanckAccount();
        account2.setAccountId(account1.getAccountId());
        account2.setCurrency(account1.getCurrency());
        account2.setType(account1.getType());
        account2.setStatus(account1.getStatus());
        Customer customer2= new Customer();
        customer2.setId(customer1.getId());
        customer2.setNom(customer1.getNom());
        customer2.setEmail(customer1.getEmail());
        account2.setCustomer(customer2);

        //2. avec prototype
        //il faut que la classe implemnts clonable et redéfinit la methode clone
        //et aussi les attribut object comme customer doit implemnter  clonable et doit redefinir clone, ainsi on ajoute dans clone de banckaccount  " banckAccount.setCustomer(this.customer.clone());"
        BanckAccount account3= account1.clone();

        System.out.println("account originale 1 :" + account1);
        System.out.println("account 2 :" + account2);
        System.out.println("account 3 :"+ account3);

        System.out.println("======== apres modification du nom de customer dans account2 et account 3");
        account2.getCustomer().setNom("ahmed");
        account3.getCustomer().setNom("ahmed");
        System.out.println("account originale 1 :" + account1);
        System.out.println("account 2 :" + account2);
        System.out.println("account 3 :"+ account3);


    }
}
