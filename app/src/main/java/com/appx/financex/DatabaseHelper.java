package com.appx.financex;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "appdata.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE CATEGORY_REGISTRY(CATEGORY_NAME TEXT PRIMARY KEY, CATEGORY_TYPE INTEGER, DESCRIPTION TEXT, ICON_ID INTEGER, THEME TEXT)");
        db.execSQL("CREATE TABLE DYNAMIC_BUDGET(CATEGORY_NAME TEXT PRIMARY KEY, SPENDING_LIMITS REAL, PAYMENT_INTERVALS INTEGER)");
        db.execSQL("CREATE TABLE META_BANK(BANK_NAME TEXT PRIMARY KEY, BANK_TYPE INTEGER, ICON_ID INTEGER, THEME TEXT)");
        db.execSQL("CREATE TABLE META_BUDGET(BUDGET_NAME TEXT PRIMARY KEY, DESCRIPTION TEXT)");
        db.execSQL("CREATE TABLE META_INVESTMENT(UID INTEGER PRIMARY KEY AUTOINCREMENT, INVESTMENT_NAME TEXT, INVESTMENT_TYPE INTEGER, LINKED_BANK TEXT, RATE REAL, TIME_FRAME INTEGER, INVESTED_AMOUNT REAL, INVESTMENT_RETURNS REAL, ICON_ID INTEGER, THEME TEXT)");
        db.execSQL("CREATE TABLE META_CARD(CARD_NO INTEGER PRIMARY KEY, CARD_ISSUER TEXT, LINKED_BANK TEXT, ICON_ID INTEGER, THEME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    
    public void createBank()
    {

    }

    public void createCard()
    {

    }

    public void addCategory(Schema.CategoryRegistry data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("CATEGORY_NAME", data.getCategoryName());
        cv.put("CATEGORY_TYPE", data.getCategoryType());
        cv.put("DESCRIPTION", data.getDescription());
        cv.put("ICON_ID", data.getIconId());
        cv.put("THEME", data.getTheme());
        db.insert("CATEGORY_REGISTRY", null, cv);
    }

    public List<Schema.CategoryRegistry> getAllCategoryRegistries()
    {
        List<Schema.CategoryRegistry> res = new ArrayList<>();

        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM CATEGORY_REGISTRY",null))
        {
            while(cur.moveToNext())
            {
                res.add(new Schema.CategoryRegistry(
                        cur.getString(cur.getColumnIndexOrThrow("CATEGORY_NAME")),
                        cur.getInt(cur.getColumnIndexOrThrow("CATEGORY_TYPE")),
                        cur.getString(cur.getColumnIndexOrThrow("DESCRIPTION")),
                        cur.getInt(cur.getColumnIndexOrThrow("ICON_ID")),
                        cur.getString(cur.getColumnIndexOrThrow("THEME"))
                ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return res;
    }

    public Schema.CategoryRegistry getCategoryRegistry(String categoryName)
    {
        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM CATEGORY_REGISTRY WHERE CATEGORY_NAME=?",new String[]{categoryName}))
        {
            if (cur.moveToNext())
            {
                return new Schema.CategoryRegistry(
                        cur.getString(cur.getColumnIndexOrThrow("CATEGORY_NAME")),
                        cur.getInt(cur.getColumnIndexOrThrow("CATEGORY_TYPE")),
                        cur.getString(cur.getColumnIndexOrThrow("DESCRIPTION")),
                        cur.getInt(cur.getColumnIndexOrThrow("ICON_ID")),
                        cur.getString(cur.getColumnIndexOrThrow("THEME"))
                );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteCategory(String categoryName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("CATEGORY_REGISTRY", "CATEGORY_NAME=?", new String[]{categoryName});
    }

    public void addBudgetItem(Schema.BudgetItem data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("BUDGET_NAME", data.getBudgetName());
        cv.put("DESCRIPTION", data.getBudgetDescription());
        db.insert("META_BUDGET",null, cv);
    }

    public List<Schema.BudgetItem> getAllBudgetItems()
    {
        List<Schema.BudgetItem> res = new ArrayList<>();

        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM META_BUDGET",null))
        {
            while (cur.moveToNext())
            {
                res.add(new Schema.BudgetItem(
                        cur.getString(cur.getColumnIndexOrThrow("BUDGET_NAME")),
                        cur.getString(cur.getColumnIndexOrThrow("DESCRIPTION"))
                ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    public void deleteBudgetItem(String budgetName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("META_BUDGET", "BUDGET_NAME=?", new String[]{budgetName});
    }

    public void addBankItem(Schema.BankItem data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("BANK_NAME", data.getBankName());
        cv.put("BANK_TYPE", data.getBankType());
        cv.put("ICON_ID", data.getIconId());
        cv.put("THEME", data.getTheme());
        db.insert("META_BANK", null, cv);
    }

    public void deleteBankItem(String bankName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("META_BANK", "BANK_NAME=?", new String[]{bankName});
    }

    public List<Schema.BankItem> getAllBankItems()
    {
        List<Schema.BankItem> res = new ArrayList<>();

        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM META_BANK",null))
        {
            while(cur.moveToNext())
            {
                res.add(new Schema.BankItem(
                        cur.getString(cur.getColumnIndexOrThrow("BANK_NAME")),
                        cur.getInt(cur.getColumnIndexOrThrow("BANK_TYPE")),
                        cur.getInt(cur.getColumnIndexOrThrow("ICON_ID")),
                        cur.getString(cur.getColumnIndexOrThrow("THEME"))
                ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    public void addInvestment(Schema.InvestmentItem data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("INVESTMENT_NAME", data.getInvestmentName());
        cv.put("INVESTMENT_TYPE", data.getInvestmentType());
        cv.put("LINKED_BANK", data.getLinkedBank());
        cv.put("RATE", data.getRate());
        cv.put("TIME_FRAME", data.getTimeFrame());
        cv.put("INVESTED_AMOUNT", data.getInvestedAmount());
        cv.put("INVESTMENT_RETURNS", data.getInvestmentReturns());
        cv.put("ICON_ID", data.getIconId());
        cv.put("THEME", data.getTheme());
        db.insert("META_INVESTMENT", null, cv);
    }

    public List<Schema.InvestmentItem> getAllInvestmentItems()
    {
        List<Schema.InvestmentItem> res = new ArrayList<>();

        try (SQLiteDatabase db = this.getWritableDatabase();
             Cursor cur = db.rawQuery("SELECT * FROM META_INVESTMENT", null))
        {
            while (cur.moveToNext()) {
                res.add(new Schema.InvestmentItem(
                        cur.getInt(cur.getColumnIndexOrThrow("UID")),
                        cur.getString(cur.getColumnIndexOrThrow("INVESTMENT_NAME")),
                        cur.getInt(cur.getColumnIndexOrThrow("INVESTMENT_TYPE")),
                        cur.getString(cur.getColumnIndexOrThrow("LINKED_BANK")),
                        cur.getDouble(cur.getColumnIndexOrThrow("RATE")),
                        cur.getInt(cur.getColumnIndexOrThrow("TIME_FRAME")),
                        cur.getDouble(cur.getColumnIndexOrThrow("INVESTED_AMOUNT")),
                        cur.getDouble(cur.getColumnIndexOrThrow("INVESTMENT_RETURNS")),
                        cur.getInt(cur.getColumnIndexOrThrow("ICON_ID")),
                        cur.getString(cur.getColumnIndexOrThrow("THEME"))
                ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    public void addCardItem(Schema.CardItem data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("CARD_NO", data.getCardNo());
        cv.put("CARD_ISSUER", data.getCardIssuer());
        cv.put("LINKED_BANK", data.getLinkedBank());
        cv.put("ICON_ID", data.getIconId());
        cv.put("THEME", data.getTheme());
        db.insert("META_CARD", null, cv);
    }

    public List<Schema.CardItem> getAllCardItems()
    {
        List<Schema.CardItem> res = new ArrayList<>();

        try (SQLiteDatabase db = this.getWritableDatabase();
             Cursor cur = db.rawQuery("SELECT * FROM META_CARD", null)) {
            while (cur.moveToNext()) {
                res.add(new Schema.CardItem(
                        cur.getInt(cur.getColumnIndexOrThrow("CARD_NO")),
                        cur.getString(cur.getColumnIndexOrThrow("CARD_ISSUER")),
                        cur.getString(cur.getColumnIndexOrThrow("LINKED_BANK")),
                        cur.getInt(cur.getColumnIndexOrThrow("ICON_ID")),
                        cur.getString(cur.getColumnIndexOrThrow("THEME"))
                ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}