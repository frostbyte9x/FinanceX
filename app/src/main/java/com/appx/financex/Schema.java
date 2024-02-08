package com.appx.financex;

public class Schema
{
    public static class SettingListData
    {
        private String header;
        private String subHeader;
        private int icon;
        private String theme;

        public SettingListData(String header, String subHeader, int icon, String theme)
        {
            this.header=header;
            this.subHeader=subHeader;
            this.icon=icon;
            this.theme = theme;
        }

        public String getHeader()
        {
            return header;
        }

        public String getSubHeader()
        {
            return subHeader;
        }

        public int getIcon()
        {
            return icon;
        }

        public String getTheme()
        {
            return theme;
        }
    }

    public static class CategoryRegistry
    {
        private String categoryName;
        private int categoryType;
        private String description;
        private int iconId;
        private String theme;
        
        public CategoryRegistry(String categoryName, int categoryType, String description, int iconId, String theme)
        {
            this.categoryName = categoryName;
            this.categoryType = categoryType;
            this.description = description;
            this.iconId = iconId;
            this.theme = theme;
        }

        public String getCategoryName()
        {
            return categoryName;
        }

        public int getCategoryType()
        {
            return categoryType;
        }

        public String getDescription()
        {
            return description;
        }

        public int getIconId()
        {
            return iconId;
        }

        public String getTheme()
        {
            return theme;
        }
    }

    public static class Budget
    {
        private String categoryName;
        private double spendingLimit;
        private int spendingIntervals;

        public Budget(String categoryName, int cid, double spendingLimit, int spendingIntervals)
        {
            this.categoryName = categoryName;
            this.spendingLimit = spendingLimit;
            this.spendingIntervals = spendingIntervals;
        }

        public String getCategoryName()
        {
            return categoryName;
        }

        public double getSpendingLimit()
        {
            return spendingLimit;
        }

        public int getSpendingIntervals()
        {
            return spendingIntervals;
        }
    }

    public static class BankItem
    {
        private String bankName;
        private int bankType;
        private int iconId;
        private String theme;


        public BankItem(String bankName, int bankType, int iconId, String theme)
        {
            this.bankName = bankName;
            this.bankType = bankType;
            this.iconId = iconId;
            this.theme = theme;
        }

        public String getBankName()
        {
            return bankName;
        }

        public int getBankType()
        {
            return bankType;
        }

        public int getIconId()
        {
            return iconId;
        }

        public String getTheme()
        {
            return theme;
        }
    }

    public static class BudgetItem
    {
        private String budgetName;
        private String budgetDescription;

        public BudgetItem(String budgetName, String budgetDescription)
        {
            this.budgetName = budgetName;
            this.budgetDescription = budgetDescription;
        }

        public String getBudgetName()
        {
            return budgetName;
        }

        public String getBudgetDescription()
        {
            return budgetDescription;
        }
    }

    public static class InvestmentItem
    {
        private int uid;
        private String investmentName;
        private int investmentType;
        private String linkedBank;
        private double rate;
        private int timeFrame;
        private double investedAmount;
        private double investmentReturns;
        private int iconId;
        private String theme;

        public InvestmentItem(int uid, String investmentName, int investmentType, String linkedBank, double rate, int timeFrame, double investedAmount, double investmentReturns, int iconId, String theme)
        {
            this.uid = uid;
            this.investmentName = investmentName;
            this.investmentType = investmentType;
            this.linkedBank = linkedBank;
            this.rate = rate;
            this.timeFrame = timeFrame;
            this.investedAmount = investedAmount;
            this.investmentReturns = investmentReturns;
            this.iconId = iconId;
            this.theme = theme;
        }

        public InvestmentItem(String investmentName, int investmentType, String linkedBank, double rate, int timeFrame, double investedAmount, double investmentReturns, int iconId, String theme)
        {
            this.investmentName = investmentName;
            this.investmentType = investmentType;
            this.linkedBank = linkedBank;
            this.rate = rate;
            this.timeFrame = timeFrame;
            this.investedAmount = investedAmount;
            this.investmentReturns = investmentReturns;
            this.iconId = iconId;
            this.theme = theme;
        }

        public int getUid()
        {
            return uid;
        }

        public String getInvestmentName()
        {
            return investmentName;
        }

        public int getInvestmentType()
        {
            return investmentType;
        }

        public String getLinkedBank()
        {
            return linkedBank;
        }

        public double getRate()
        {
            return rate;
        }

        public int getTimeFrame()
        {
            return timeFrame;
        }

        public double getInvestedAmount()
        {
            return investedAmount;
        }

        public double getInvestmentReturns()
        {
            return investmentReturns;
        }

        public int getIconId()
        {
            return iconId;
        }

        public String getTheme()
        {
            return theme;
        }
    }

    public static class CardItem
    {
        private int cardNo;
        private String cardIssuer;
        private String linkedBank;
        private int iconId;
        private String theme;
        
        public CardItem(int cardNo, String cardIssuer, String linkedBank, int iconId, String theme)
        {
            this.cardNo = cardNo;
            this.cardIssuer = cardIssuer;
            this.linkedBank = linkedBank;
            this.iconId = iconId;
            this.theme = theme;
        }

        public int getCardNo()
        {
            return cardNo;
        }

        public String getCardIssuer()
        {
            return cardIssuer;
        }

        public String getLinkedBank()
        {
            return linkedBank;
        }

        public int getIconId()
        {
            return iconId;
        }

        public String getTheme()
        {
            return theme;
        }
    }
}