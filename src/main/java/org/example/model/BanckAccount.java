package org.example.model;
public class BanckAccount {

        private Long accountId;
        private double balance;
        private String currency;
        private AccountType type;
        private AccountStatus status;

        // Constructeur sans paramètres
        public BanckAccount() {
        }

        // Constructeur avec tous les paramètres
        public BanckAccount(Long accountId, double balance, String currency,
                            AccountType type, AccountStatus status) {
                this.accountId = accountId;
                this.balance = balance;
                this.currency = currency;
                this.type = type;
                this.status = status;
        }

        // Getters et Setters

        public Long getAccountId() {
                return accountId;
        }

        public void setAccountId(Long accountId) {
                this.accountId = accountId;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }

        public String getCurrency() {
                return currency;
        }

        public void setCurrency(String currency) {
                this.currency = currency;
        }

        public AccountType getType() {
                return type;
        }

        public void setType(AccountType type) {
                this.type = type;
        }

        public AccountStatus getStatus() {
                return status;
        }

        public void setStatus(AccountStatus status) {
                this.status = status;

        }

        @Override
        public String toString() {
                return "BanckAccount{" +
                        "accountId=" + accountId +
                        ", balance=" + balance +
                        ", currency='" + currency + '\'' +
                        ", type=" + type +
                        ", status=" + status +
                        '}';
        }









        public static class BanckAccountBuilder{
             private BanckAccount banckAccount = new BanckAccount();

             public BanckAccountBuilder accountId(Long id){
                     banckAccount.accountId=id;
                     return this;
             }

                public BanckAccountBuilder currency(String currency){
                        banckAccount.currency=currency;
                        return this;
                }
                public BanckAccountBuilder balance(double balance) {
                        banckAccount.balance = balance;
                        return this;
                }
                public BanckAccountBuilder type(AccountType type){

                                banckAccount.type=type;
                                return this;


                        }
                public BanckAccountBuilder status(AccountStatus status){
                     //on peut ajouter des regles métier
                        if(banckAccount.getType().equals(AccountType.CURRENT_ACCOUNT))
                                banckAccount.status=status;
                        else banckAccount.status=AccountStatus.ACTIVATED;
                        return this;
                }

                public BanckAccount build(){
                     return this.banckAccount;
                }

        }



}