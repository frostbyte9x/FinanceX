package com.appx.financex;

import android.content.Context;
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
        db.execSQL("CREATE TABLE DYNAMIC_BUDGET(UID PRIMARY KEY, CID INTEGER, SPENDING_LIMITS REAL, PAYMENT_INTERVALS INTEGER)");
        db.execSQL("CREATE TABLE META_BANK(UID PRIMARY KEY AUTOINCREMENT, BANK_NAME TEXT, BANK_TYPE INTEGER, ICON_ID TEXT, THEME TEXT, LAST_TRAN_DATE TEXT, AVL_BAL REAL)");
        db.execSQL("CREATE TABLE META_BUDGET(UID PRIMARY KEY AUTOINCREMENT, BUDGET_NAME TEXT)");
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
}