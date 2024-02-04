package com.appx.financex;

public class Data
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
        private int categoryId;
        private String categoryName;
        private int categoryType;
        private String description;
        private int iconId;
        private String theme;
        
        public CategoryRegistry(int categoryId, String categoryName, int categoryType, String description, int iconId, String theme)
        {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.categoryType = categoryType;
            this.description = description;
            this.iconId = iconId;
            this.theme = theme;
        }

        public int getCategoryId()
        {
            return categoryId;
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
        private int uid;
        private int cid;
        private double spendingLimit;
        private int spendingIntervals;

        public Budget(int uid, int cid, double spendingLimit, int spendingIntervals)
        {
            this.uid = uid;
            this.cid = cid;
            this.spendingLimit = spendingLimit;
            this.spendingIntervals = spendingIntervals;
        }

        public int getUid()
        {
            return uid;
        }

        public int getCid()
        {
            return cid;
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

    public static class BankData
    {
        private int uid;
        private String bankName;
        private int bankType;
        private int iconId;
        private String theme;
        private double availableBalance;

        public BankData(int uid, String bankName, int bankType, int iconId, String theme, double availableBalance)
        {
            this.uid = uid;
            this.bankName = bankName;
            this.bankType = bankType;
            this.iconId = iconId;
            this.theme = theme;
            this.availableBalance = availableBalance;
        }

        public int getUid()
        {
            return uid;
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

        public double getAvailableBalance()
        {
            return availableBalance;
        }
    }

    public static class BudgetItem
    {
        private int uid;
        private String budgetName;

        public BudgetItem(int uid, String budgetName)
        {
            this.uid = uid;
            this.budgetName = budgetName;
        }

        public int getUid()
        {
            return uid;
        }

        public String getBudgetName()
        {
            return budgetName;
        }
    }
}