package com.example.posii_client;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static String DATABASE_NAME="Restaurent.db";
	private static int DATABASE_VESION=1;
	private SQLiteDatabase db;
	static final String USER_ID="user_id";
	static final String USER_NAME="user_name";
	static final String CREATE_TIME="create_time";
	static final String UPDATE_TIME="update_time";
	static final String FLAG="flag";
	static final String PASSWORD="password";
	static final String GENDER="gender";
	static final String BIRTHDAY="birthday";
	static final String ADDRESS="address";
	static final String PHONE_NUMBER="phone_number";
	static final String ACTIVATION="activation";
	static final String USER_GROUP_ID="user_group_id";
	static final String GROUP_NAME="group_name";
	static final String ROLES_ID="roles_id";
	static final String USER_TABLE="uer";
//	static final String CREATE_TIME="create_time";
//	static final String UPDATE_TIME="update_time";
//	static final String
	
	
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME,null, DATABASE_VESION);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
