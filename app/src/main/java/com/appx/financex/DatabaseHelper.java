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
        db.execSQL("CREATE TABLE CATEGORY_REGISTRY(CID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY_NAME TEXT, CATEGORY_TYPE INTEGER, DESCRIPTION TEXT, ICON_ID INTEGER, THEME TEXT)");
        db.execSQL("CREATE TABLE DYNAMIC_BUDGET(UID INTEGER PRIMARY KEY, CID INTEGER, SPENDING_LIMITS REAL, PAYMENT_INTERVALS INTEGER)");
        db.execSQL("CREATE TABLE META_BANK(UID INTEGER PRIMARY KEY AUTOINCREMENT, BANK_NAME TEXT, BANK_TYPE INTEGER, ICON_ID TEXT, THEME TEXT, AVL_BAL REAL)");
        db.execSQL("CREATE TABLE META_BUDGET(UID INTEGER PRIMARY KEY AUTOINCREMENT, BUDGET_NAME TEXT)");
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

    public void addCategory(Data.CategoryRegistry data)
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

    public List<Data.CategoryRegistry> getAllCategoryRegistries()
    {
        List<Data.CategoryRegistry> res = new ArrayList<>();

        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM CATEGORY_REGISTRY",null))
        {
            while(cur.moveToNext())
            {
                res.add(new Data.CategoryRegistry(
                        cur.getInt(cur.getColumnIndexOrThrow("CID")),
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

    public Data.CategoryRegistry getCategoryRegistry(String categoryName)
    {
        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM CATEGORY_REGISTRY WHERE CATEGORY_NAME=?",new String[]{categoryName}))
        {
            if (cur.moveToNext())
            {
                return new Data.CategoryRegistry(
                        cur.getInt(cur.getColumnIndexOrThrow("CID")),
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

    public void deleteCategory(int categoryId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("CATEGORY_REGISTRY", "CID=?", new String[]{Integer.toString(categoryId)});
    }

    public void deleteAllCategories()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("CATEGORY_REGISTRY",null,null);
    }

    public void addBudgetItem(Data.BudgetItem data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("BUDGET_NAME", data.getBudgetName());
        db.insert("META_BUDGET",null, cv);
    }

    public List<Data.BudgetItem> getAllBudgetItems()
    {
        List<Data.BudgetItem> res = new ArrayList<>();

        try(SQLiteDatabase db = getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT * FROM META_BUDGET",null))
        {
            res.add(new Data.BudgetItem(
                    cur.getInt(cur.getColumnIndexOrThrow("UID")),
                    cur.getString(cur.getColumnIndexOrThrow("BUDGET_NAME"))
            ));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}