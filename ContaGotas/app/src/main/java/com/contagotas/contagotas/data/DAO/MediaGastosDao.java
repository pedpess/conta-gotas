package com.contagotas.contagotas.data.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.contagotas.contagotas.data.DAO.MediaGastos;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MEDIA_GASTOS.
*/
public class MediaGastosDao extends AbstractDao<MediaGastos, Long> {

    public static final String TABLENAME = "MEDIA_GASTOS";

    /**
     * Properties of entity MediaGastos.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Total = new Property(1, Float.class, "total", false, "TOTAL");
        public final static Property Data = new Property(2, String.class, "data", false, "DATA");
        public final static Property Is_deleted = new Property(3, Boolean.class, "is_deleted", false, "IS_DELETED");
    };


    public MediaGastosDao(DaoConfig config) {
        super(config);
    }
    
    public MediaGastosDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MEDIA_GASTOS' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'TOTAL' REAL," + // 1: total
                "'DATA' TEXT," + // 2: data
                "'IS_DELETED' INTEGER);"); // 3: is_deleted
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_MEDIA_GASTOS__id ON MEDIA_GASTOS" +
                " (_id);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MEDIA_GASTOS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MediaGastos entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Float total = entity.getTotal();
        if (total != null) {
            stmt.bindDouble(2, total);
        }
 
        String data = entity.getData();
        if (data != null) {
            stmt.bindString(3, data);
        }
 
        Boolean is_deleted = entity.getIs_deleted();
        if (is_deleted != null) {
            stmt.bindLong(4, is_deleted ? 1l: 0l);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MediaGastos readEntity(Cursor cursor, int offset) {
        MediaGastos entity = new MediaGastos( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1), // total
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // data
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0 // is_deleted
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MediaGastos entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTotal(cursor.isNull(offset + 1) ? null : cursor.getFloat(offset + 1));
        entity.setData(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIs_deleted(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MediaGastos entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MediaGastos entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
