package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 12/09/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Luna on 22/07/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    // Database Version 1.0
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DBMOVIL5";

//------------------------------ ******   DEFINICION DE TABLAS   ****** ------------------------------

    // ***********************TABLA Usuarios***********************
    private static final String TABLE_Usuarios = "Usuarios";
                            //CAMPOS
    private static final String Login = "Login";
    private static final String  Password = "Password";
    private static final String  nombreUsuario = "Nombre";
                            //STRING PARA CREAR TABLA
    String CREATE_Table_Usuarios = "CREATE TABLE " + TABLE_Usuarios + " ( "
            + Login + " TEXT PRIMARY KEY, " + Password +" TEXT, " + nombreUsuario +" TEXT)";
    //***************************************************************

    // ***********************TABLA Marcas***********************
    private static final String TABLE_Marcas = "Marcas";
                                //CAMPOS
    private static final String idMarca = "idMarca";
    private static final String  nombreMarca = "nombre";
                        //STRING PARA CREAR TABLA
    String CREATE_Table_Marcas = "CREATE TABLE " + TABLE_Marcas + "("
            + idMarca + " INTEGER PRIMARY KEY, " + nombreMarca + " TEXT)";
    //************************************************************

    // ***********************TABLA Dispositivos***********************
    private static final String TABLE_Dispositivos = "Dispositivos";
                            //CAMPOS
    private static final String idDipositivo = "idDipositivo";
    private static final String  nombreDispositivos = "nombre";
                    //STRING PARA CREAR TABLA
    String CREATE_Table_Dispositivos = "CREATE TABLE " + TABLE_Dispositivos + "("
            + idDipositivo + " INTEGER PRIMARY KEY, " + nombreDispositivos + " TEXT)";
    //****************************************************************

    // ***********************TABLA Modelos***********************
    private static final String TABLE_Modelos = "Modelos";
                                //CAMPOS
    private static final String idModelo = "idModelo";
    private static final String  nombreModelo = "nombre";
    private static final String  idDispositivoFK = "idDispositivo";
    private static final String  idMarcaFK = "idMarca";
                        //STRING PARA CREAR TABLA
    String CREATE_Table_Modelos = "CREATE TABLE " + TABLE_Modelos + " ("
            + idModelo + " INTEGER PRIMARY KEY, " + nombreModelo + " TEXT, "+ idDispositivoFK +" INTEGER, " + idMarcaFK +" INTEGER, " +
            " FOREIGN KEY ("+ idDispositivoFK+") REFERENCES "+ TABLE_Dispositivos+"("+ idDipositivo+"), " +
            " FOREIGN KEY ("+ idMarcaFK+") REFERENCES  "+ TABLE_Marcas+"("+ idMarca+"))";
    //****************************************************************


    // ***********************TABLA Unidades***********************
    private static final String TABLE_Unidades = "Unidades";
                              //CAMPOS
    private static final String NumeroUnidadUni = "NumeroUnidad";
    private static final String  encargadoUni = "encargado";
                    //STRING PARA CREAR TABLA
    String CREATE_Table_Unidades = "CREATE TABLE " + TABLE_Unidades + " ("
            + NumeroUnidadUni + " INTEGER PRIMARY KEY, " + encargadoUni + " NVARCHAR(50))";
    //****************************************************************

    // ***********************TABLA Departamentos***********************
    private static final String TABLE_Departamentos = "Departamentos";
                                //CAMPOS
    private static final String CodDepartamentoDepa = "CodDepartamento";
    private static final String  DescripcionDepa = "Descripcion";
                        //STRING PARA CREAR TABLA
    String CREATE_Table_Departamentos = "CREATE TABLE " + TABLE_Departamentos + " ("
            + CodDepartamentoDepa + " INTEGER PRIMARY KEY, " + DescripcionDepa + " NVARCHAR(100))";
    //****************************************************************

    // ***********************TABLA Departamento_Area***********************
    private static final String TABLE_Departamento_Area = "Departamento_Area";
                                    //CAMPOS
    private static final String idAreaDepUnid = "idAreaDepUnid";
    private static final String  NumeroUnidadFK = "NumeroUnidad";
    private static final String  CodDepartamentoFK = "CodDepartamento";
    private static final String  areaDepAr = "area";
                            //STRING PARA CREAR TABLA
    String CREATE_Table_Departamento_Area = "CREATE TABLE " + TABLE_Departamento_Area + " ("
            + idAreaDepUnid + " INTEGER PRIMARY KEY, " + NumeroUnidadFK +" INTEGER, "+ CodDepartamentoFK +" INTEGER, "+  areaDepAr + " NVARCHAR(100), " +
                               " FOREIGN KEY ("+ NumeroUnidadFK+") REFERENCES "+ TABLE_Unidades+" ( "+NumeroUnidad+" ),"+
                               " FOREIGN KEY ("+ CodDepartamentoFK+") REFERENCES "+ TABLE_Departamentos+" ("+CodDepartamento+"))";
    //****************************************************************

    // ***********************TABLA Categorias***********************

    private static final String TABLE_Categorias = "Categorias";
                                //CAMPOS
    private static final String clave = "clave";
    private static final String  Descripcion = "Descripcion";;
                            //STRING PARA CREAR TABLA
    String CREATE_Table_Categorias = "CREATE TABLE " + TABLE_Categorias + " ( "
            + clave + " TEXT PRIMARY KEY, " + Descripcion +" TEXT )";
    //****************************************************************

     // ***********************TABLA Trabajadores***********************
    private static final String TABLE_Trabajadores = "Trabajadores";
    //CAMPOS
    private static final String Matricula = "Matricula";
    private static final String  Nombre = "Nombre";
    private static final String  Puesto = "Puesto";
    //STRING PARA CREAR TABLA
    String CREATE_Table_Trabajadores = "CREATE TABLE " + TABLE_Trabajadores + " ( "
            + Matricula + " INTEGER PRIMARY KEY, " + Nombre +" TEXT, " +
            Puesto +" TEXT, "+
            " FOREIGN KEY ("+ Puesto+") REFERENCES "+ TABLE_Categorias+" ("+clave+"))";
    //***************************************************************

    // ***********************TABLA Switchers***********************
    private static final String TABLE_Switchers = "Switchers";
                                //CAMPOS
    private static final String idSwitcher = "idSwitcher";
    private static final String  mdf = "mdf";
    private static final String  numMdf = "numMdf";
    private static final String  rack = "rack";
    private static final String  numRack = "numRack";
                        //STRING PARA CREAR TABLA
    String CREATE_Table_Switchers = "CREATE TABLE " + TABLE_Switchers + " ( "
            + idSwitcher + " INTEGER PRIMARY KEY, " + mdf +" TEXT, " + numMdf +" INTEGER, " + rack +" TEXT, " + numRack +" INTEGER )";
    //***************************************************************


    // ***********************TABLA detalleSwitcher***********************
    private static final String TABLE_detalleSwitcher = "detalleSwitcher";
                                    //CAMPOS
    private static final String numSerieSwit = "numSerie";
    private static final String  idSwitcherFK = "idSwitcher";
    private static final String  numero = "numero";
    private static final String  propiedad = "propiedad";

    //STRING PARA CREAR TABLA
    String CREATE_Table_detalleSwitcher = "CREATE TABLE " + TABLE_detalleSwitcher + " ( "
            + numSerieSwit + " TEXT PRIMARY KEY, " + idSwitcher +" INTEGER, " + numero +" TEXT, " + propiedad +" INTEGER, " +
            " FOREIGN KEY ("+ idSwitcherFK+") REFERENCES "+ TABLE_Switchers+" ( "+idSwitcher+"))";
    //***************************************************************

    // ***********************TABLA FotoConductores***********************
    private static final String TABLE_FotoConductores = "FotoConductores";
                                //CAMPOS
    private static final String id = "id";
    private static final String  descripcionFot = "descripcion";
    private static final String  rendimiento = "rendimiento";
                        //STRING PARA CREAR TABLA
    String CREATE_Table_FotoConductores = "CREATE TABLE " + TABLE_FotoConductores + "("
            + id + " INTEGER PRIMARY KEY, " + descripcionFot +" TEXT," + rendimiento +" TEXT)";
    //***************************************************************

    // ***********************TABLA ImpresorasContadores***********************
    private static final String TABLE_ImpresorasContadores = "ImpresorasContadores";
    //CAMPOS
    private static final String folio = "folio";
    private static final String  serie = "serie";
    private static final String  idFotoconductor = "idFotoconductor";
    private static final String  contador = "contador";
    //STRING PARA CREAR TABLA
    String CREATE_Table_ImpresorasContadores = "CREATE TABLE " + TABLE_ImpresorasContadores + "( "
            + folio + " INTEGER, " + serie +" TEXT, " + idFotoconductor +" INTEGER, "+ contador+ " INTEGER, " +
            " FOREIGN KEY ("+ folio+") REFERENCES "+ TABLE_ordenServicioDispositivos+" ("+folioOrdenServicio+"), " +
            " FOREIGN KEY ("+ idFotoconductor+") REFERENCES "+ TABLE_FotoConductores+" ("+id+"))";
    //***************************************************************

    // ***********************TABLA detalleEquipos***********************
      private static final String TABLE_detalleEquipos = "detalleEquipos";
    //CAMPOS
    private static final String  idDetalleEquipo = " idDetalleEquipo";
    private static final String  numSerieEquipos = " numSerie";
    private static final String  ipDetaEquipo = "ip";
    private static final String  macaddress = "macaddress";
    private static final String  hostDetaEquipo = "host";
    private static final String  observacionesDetaEquipo = "observaciones";
    private static final String  idAreaDepUnidFK = "idAreaDepUnid";
    private static final String  extensionDetaEquipo = "extension";
    private static final String  matricula = "matricula";
    private static final String  nombreDetaEquipo = "nombre";
    private static final String  apellidopaterno = "apellidopaterno";
    private static final String  apellidomaterno = "apellidomaterno";
    private static final String  puestoDetaEquipo = "puesto";
    private static final String  impresora = "impresora";
    private static final String  observacionImpresora = "observacionImpresora";
    //STRING PARA CREAR TABLA
    String CREATE_Table_detalleEquipos = "CREATE TABLE " + TABLE_detalleEquipos + " ( "
            + idDetalleEquipo + " INTEGER PRIMARY KEY, " + numSerieEquipos +" TEXT, " + ipDetaEquipo +" TEXT, "+ macaddress+ " TEXT, " + hostDetaEquipo + " TEXT, "+ observacionesDetaEquipo +" TEXT, "
            +idAreaDepUnidFK + " INTEGER,"+ extensionDetaEquipo + " TEXT," + matricula + " TEXT," + nombreDetaEquipo + " TEXT," + apellidopaterno + " TEXT," + apellidomaterno + " TEXT,"
            + puestoDetaEquipo + " TEXT, " + impresora + " INTEGER, "+ observacionImpresora + " TEXT, "
            +" FOREIGN KEY ("+ numSerieEquipos+") REFERENCES " + TABLE_Equipos+" ("+numSerieEquipos+"), "
            +" FOREIGN KEY ("+ idAreaDepUnidFK+") REFERENCES "+ TABLE_Departamento_Area+" ("+idAreaDepUnid+"))";
    //*****************************************************************************************************************************************

    // ***********************TABLA Equipos*********************************************************************************************
     private static final String TABLE_Equipos = "Equipos";
    //CAMPOS
    private static final String  numSerieEqui = " numSerieEqui";
    private static final String  numeroInventario = " numeroInventario";
    private static final String idModeloFK = "idModelo";
    private static final String  status = "status";

    //STRING PARA CREAR TABLA
    String CREATE_Table_Equipos = "CREATE TABLE " + TABLE_Equipos + " ( "
            + numSerieEqui + " TEXT PRIMARY KEY, " + numeroInventario +" TEXT, " + idModeloFK +" INTEGER, "+ status+ " INTEGER, "
            +" FOREIGN KEY ("+ idModeloFK+") REFERENCES "+ TABLE_Modelos+" ("+idModelo+"))";
    //*****************************************************************************************************************************************

    // ***********************TABLA ordenServicioDispositivos****************************************************************************************************
    private static final String TABLE_ordenServicioDispositivos = "ordenServicioDispositivos";
    //CAMPOS
    private static final String  folioOrdenServicio = " folioOrdenServicio";
    private static final String  tipo = " tipo";
    private static final String fecha = "fecha";
    private static final String  numSerie = "numSerie";
    private static final String  piso = " piso";
    private static final String  extension = " extension";
    private static final String matriculaFK = "matricula";
    private static final String  nombre = "nombre";
    private static final String  apellidoM = " apellidoM";
    private static final String  apellidoP = " apellidoP";
    private static final String puesto = "puesto";
    private static final String  observaciones = "observaciones";
    private static final String  idInstaladorFK = " idInstalador ";
    private static final String  NumeroUnidad = " NumeroUnidad";
    private static final String CodDepartamento = "CodDepartamento";
    private static final String  area = "area";
    private static final String  encargado = " encargado";
    private static final String  tipoUbicacion = " tipoUbicacion";
    private static final String  host = " host";
    private static final String ip = "ip";
    private static final String  tipoRack = "tipoRack";
    private static final String  fechaActualizacion = " fechaActualizacion";
    private static final String statusEquipo = "statusEquipo";

    //STRING PARA CREAR TABLA
    String CREATE_Table_ordenServicioDispositivos = "CREATE TABLE " + TABLE_ordenServicioDispositivos + " ( "
            +folioOrdenServicio+" INTEGER PRIMARY KEY, " + tipo +" INTEGER, " +  fecha +" DATETIME, "+ numSerie+ " TEXT, " + piso + " TEXT, "+ extension +" TEXT, "
            + matriculaFK +" INTEGER, "+ nombre + " TEXT, " + apellidoM + " TEXT, " + apellidoP + " TEXT, " + puesto + " TEXT, " + observaciones + " TEXT, "
            + idInstaladorFK + " TEXT, " + NumeroUnidad + " INTEGER, "+ CodDepartamento + " INTEGER, "+ area + " TEXT, " + encargado + " TEXT, "+ tipoUbicacion + " INTEGER, "
            + host +" TEXT, "+ ip+ " TEXT, "+ tipoRack + " TEXT, " + fechaActualizacion + " DATETIME, "+ statusEquipo + " INTEGER, "
            +" FOREIGN KEY ("+ matriculaFK+") REFERENCES " + TABLE_Trabajadores+" ("+Matricula+"),"
            +" FOREIGN KEY ("+ idInstaladorFK+") REFERENCES "+ TABLE_Usuarios+" ("+Login+"))";
    //*****************************************************************************************************************************************





//------------------------------ ******  FIN DEFINICION DE TABLAS   ****** ------------------------------

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Table_Usuarios);
        db.execSQL(CREATE_Table_Marcas);
        db.execSQL(CREATE_Table_Dispositivos);
        db.execSQL(CREATE_Table_Modelos);
        db.execSQL(CREATE_Table_Unidades);
        db.execSQL(CREATE_Table_Departamentos);
        db.execSQL(CREATE_Table_Departamento_Area);
        db.execSQL(CREATE_Table_Categorias);
        db.execSQL(CREATE_Table_Trabajadores);
        db.execSQL(CREATE_Table_Switchers);
        db.execSQL(CREATE_Table_detalleSwitcher);
        db.execSQL(CREATE_Table_FotoConductores);
        db.execSQL(CREATE_Table_ImpresorasContadores);
        db.execSQL(CREATE_Table_detalleEquipos);
        db.execSQL(CREATE_Table_Equipos);
        db.execSQL(CREATE_Table_ordenServicioDispositivos);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Elimina la tabla anterior si exisitia
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Usuarios);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Dispositivos);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Marcas);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Modelos);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Unidades);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Departamentos);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Departamento_Area);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Categorias);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Trabajadores);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Switchers);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_detalleSwitcher);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FotoConductores);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ImpresorasContadores);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_detalleEquipos);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Equipos);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ordenServicioDispositivos);
        // Crea la tabla de nuevo
        onCreate(db);
    }

    public void fastInsert( JSONArray jArray)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        JSONObject jObject = null;
        try {



        /////////////SEPARA EL JSON EN CADA TABLA E INSERTA///////////////

//-----------------------------TABLES_Usuarios-------------------------------------------------------------------------------
            jObject = new JSONObject(String.valueOf(jArray.getJSONObject(0)));
            JSONArray Datos = jObject.getJSONArray("Usuarios");
            //db.insertFastUsuarios(Datos);
            JSONObject Object;
            // you can use INSERT only
            String sql = "INSERT OR REPLACE INTO " + TABLE_Usuarios + " ( Login, Password, nombre ) VALUES ( ?, ?, ? )";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();

            SQLiteStatement stmt = db.compileStatement(sql);

            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array
                String Login = Object.getString("Login");
                String Password = Object.getString("Password");
                String nombre  = URLDecoder.decode(Object.getString("nombre"),"UTF-8");

                stmt.bindString(1,Login);
                stmt.bindString(2, Password);
                stmt.bindString(3, nombre);

                Log.i("LOGIN: ", Login);
            }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
//------------------------------------------------------------------------------------------------------------

//----------------------------------TABLE_Unidades--------------------------------------------------------------------------
            jObject = new JSONObject(String.valueOf(jArray.getJSONObject(1)));
            Datos = jObject.getJSONArray("Unidades");
            // you can use INSERT only
          sql = "INSERT OR REPLACE INTO " + TABLE_Unidades + " ( NumeroUnidad, Encargado ) VALUES ( ?, ? )";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array
                String NumeroUnidad = Object.getString("NumeroUnidad");
                String Encargado = URLDecoder.decode(Object.getString("Encargado"),"UTF-8");

                stmt.bindString(1,NumeroUnidad);
                stmt.bindString(2, Encargado);


            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();


//------------------------------------------------------------------------------------------------------------

//----------------------------------TABLE_DEPARTAMENTOS---------------------------------------------------------------------------------
            jObject = new JSONObject(String.valueOf(jArray.getJSONObject(2)));
            Datos = jObject.getJSONArray("Areas");
            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_Departamentos + " ( CodDepartamento, Descripcion ) VALUES ( ?, ? )";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array
                String CodDepartamento = Object.getString("CodDepartamento");
                String Descripcion = URLDecoder.decode(Object.getString("Descripcion"),"UTF-8");

                stmt.bindString(1,CodDepartamento);
                stmt.bindString(2, Descripcion);


            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
          //  --------------------------------------------------------------
            //---------------------------------TABLE_Departamento_Area-------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(3)));
        Datos = jObject.getJSONArray("Depto_Areas");


            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_Departamento_Area + " ( idAreaDepUnid, NumeroUnidad,CodDepartamento,area ) VALUES ( ?, ?,?,?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array


                String id = Object.getString("id");
                String idUnidad = Object.getString("idUnidad");
                String depto = Object.getString("depto");
                String area = URLDecoder.decode(Object.getString("area"),"UTF-8");

                stmt.bindString(1,id);
                stmt.bindString(2, idUnidad);
                stmt.bindString(3, depto);
                stmt.bindString(4, area);

            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
            //----------------------------------------------------------------------------------------

            //--------------------------TABLE_detalleEquipos--------------------------------------------------------------


        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(4)));
        Datos = jObject.getJSONArray("detalleEquipos");
            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_detalleEquipos + " ( idDetalleEquipo, numSerie,ip,macaddress, host, observaciones, extension," +
                    " matricula, nombre, apellidopaterno, apellidomaterno, puesto, impresora, observacionImpresora   ) VALUES ( ?, ?,?,?, ?,?," +
                    "?, ?,?,?, ?,?,?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                String id = Object.getString("id");
                String serie =URLDecoder.decode(Object.getString("serie"),"UTF-8");
                String ip = URLDecoder.decode(Object.getString("ip"),"UTF-8");
                String macaddress = URLDecoder.decode(Object.getString("macaddress"),"UTF-8");
                String host = URLDecoder.decode(Object.getString("host"),"UTF-8");
                String observaciones = URLDecoder.decode(Object.getString("observaciones"),"UTF-8");
                String extension = URLDecoder.decode(Object.getString("extension"),"UTF-8");
                String matricula = URLDecoder.decode(Object.getString("matricula"),"UTF-8");
                String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                String apellidopaterno = URLDecoder.decode(Object.getString("apellidopaterno"),"UTF-8");
                String apellidomaterno = URLDecoder.decode(Object.getString("apellidomaterno"),"UTF-8");
                String puesto = URLDecoder.decode(Object.getString("puesto"),"UTF-8");
                String impresora = URLDecoder.decode(Object.getString("impresora"),"UTF-8");
                String observacionImpresora = URLDecoder.decode(Object.getString("observacionImpresora"),"UTF-8");

                stmt.bindString(1,id);
                stmt.bindString(2, serie);
                stmt.bindString(3, ip);
                stmt.bindString(4, macaddress);
                stmt.bindString(5, host);
                stmt.bindString(6, observaciones);
                stmt.bindString(7, extension);
                stmt.bindString(8, matricula);
                stmt.bindString(9, nombre);
                stmt.bindString(10, apellidopaterno);
                stmt.bindString(11, apellidomaterno);
                stmt.bindString(12, puesto);
                stmt.bindString(13, impresora);
                stmt.bindString(14, observacionImpresora);


            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();

      //---------------------------------------------------------------------------


            // ---------------------------TABLE_Marcas------------------------------------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(5)));
        Datos = jObject.getJSONArray("Marcas");
            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_Marcas + " ( idMarca, nombre ) VALUES ( ?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                String clave = Object.getString("clave");
                String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");


                stmt.bindString(1,clave);
                stmt.bindString(2, nombre);

             }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();

        //--------------------------------------------------------------
            //-----------------------TABLE_Dispositivos------------------------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(6)));
        Datos = jObject.getJSONArray("Dispositivos");
            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_Dispositivos + " ( idDipositivo, nombre ) VALUES ( ?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                String clave = Object.getString("clave");
                String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");

                stmt.bindString(1,clave);
                stmt.bindString(2, nombre);

            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();

        //-------------------------------------------------------------------------------
            //---------------------------------TABLE_Modelos-----------------------------
        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(7)));
        Datos = jObject.getJSONArray("Modelos");
            // you can use INSERT only
            sql = "INSERT OR REPLACE INTO " + TABLE_Modelos + " ( idModelo, nombre,idDispositivo,idMarca ) VALUES ( ?, ?, ?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                String id = Object.getString("id");
                String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
                String idDispositivo = Object.getString("idDispositivo");
                String idMarca = Object.getString("idMarca");

                stmt.bindString(1,id);
                stmt.bindString(2, nombre);
                stmt.bindString(3, idDispositivo);
                stmt.bindString(4, idMarca);

            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();


            //--------------------------------------------------------------------
            //--------------------------TABLE_Equipos-----------------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(8)));
        Datos = jObject.getJSONArray("Equipos");
            sql = "INSERT OR REPLACE INTO " + TABLE_Equipos + " ( numSerieEqui, numeroInventario,idModelo,status ) VALUES ( ?, ?, ?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                String numeroSerie = URLDecoder.decode(Object.getString("numeroSerie"),"UTF-8");
                String numeroInventario = Object.getString("numeroInventario");
                String idModelo = Object.getString("idModelo");
                String status = Object.getString("status");

                stmt.bindString(1,numeroSerie);
                stmt.bindString(2, numeroInventario);
                stmt.bindString(3, idModelo);
                stmt.bindString(4, status);

            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();




            //---------------------------------------------------------

            //--------------------------TABLE_Categorias----------------------------------
            jObject = new JSONObject(String.valueOf(jArray.getJSONObject(9)));
            Datos = jObject.getJSONArray("Categorias");
            sql = "INSERT OR REPLACE INTO " + TABLE_Categorias + " ( clave,  descripcion ) VALUES ( ?, ?)";
          //  sql = "INSERT OR REPLACE INTO " + TABLE_Categorias + " ( idCategoria, clave, descripcion ) VALUES ( ?, ?, ?)";
		/*
		 * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
		 * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
		 * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
		 */
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)
            {
                Object = Datos.getJSONObject(i);
                // Pulling items from the array

                //String id = Object.getString("id");
                String clave = Object.getString("clave");
                String descripcion = Object.getString("descripcion");



               // stmt.bindString(1,id);
                stmt.bindString(1, clave);
                stmt.bindString(2, descripcion);


            }

            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
            //------------------------------------------------------------

            //----------------------------Table_Trabajadores--------------------------------



        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(10)));
        Datos = jObject.getJSONArray("Trabajadores");
            sql = "INSERT OR REPLACE INTO " + TABLE_Trabajadores + " ( Matricula, Nombre,Puesto ) VALUES ( ?, ?,?)";
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
            for (int i=0; i < Datos.length(); i++)

        {
            Object = Datos.getJSONObject(i);
            // Pulling items from the array

            String matricula = Object.getString("matricula");
            String nombre = URLDecoder.decode(Object.getString("nombre"),"UTF-8");
            String puesto = Object.getString("puesto");

            stmt.bindString(1,matricula);
            stmt.bindString(2, nombre);
            stmt.bindString(3,puesto);


        }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
//-------------------------------------------------------------------------------------
            //------------------------------------Table_Switchers---------------------
        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(11)));
        Datos = jObject.getJSONArray("Switchers");
            sql = "INSERT OR REPLACE INTO " + TABLE_Switchers + " ( idSwitcher,mdf, numMdf,rack,numRack ) VALUES (?,?, ?, ?,?)";
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);


            for (int i=0; i < Datos.length(); i++)
        {
            Object = Datos.getJSONObject(i);
            // Pulling items from the array

            String id = Object.getString("id");
            String mdf = Object.getString("mdf");
            String numMdf = Object.getString("numMdf");
            String rack = Object.getString("rack");
            String numRack = Object.getString("numRack");

            stmt.bindString(1,id);
            stmt.bindString(2, mdf);
            stmt.bindString(3,numMdf);
            stmt.bindString(4,rack);
            stmt.bindString(5, numRack);
        }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();

            //------------------------------------------------------------
           //----------------------------TABLE_detalleSwitcher----------------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(12)));
        Datos = jObject.getJSONArray("DetalleSwitcher");
            sql = "INSERT OR REPLACE INTO " + TABLE_detalleSwitcher + " ( numSerie,idSwitcher, numero, propiedad ) VALUES (?,?, ?, ?)";
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
        for (int i=0; i < Datos.length(); i++)
        {
            Object = Datos.getJSONObject(i);
            // Pulling items from the array

            String serie = Object.getString("serie");
            String idSwitcher = Object.getString("idSwitcher");
            String numero = Object.getString("numero");
            String propiedad = Object.getString("propiedad");

            stmt.bindString(1,serie);
            stmt.bindString(2, idSwitcher);
            stmt.bindString(3,numero);
            stmt.bindString(4,propiedad);



        }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();

//------------------------------------------------------------------------------------------------------
            //------------------------TABLE_FotoConductores-------------------------------------------------------------------
            jObject = new JSONObject(String.valueOf(jArray.getJSONObject(13)));
        Datos = jObject.getJSONArray("FotoConductores");
            sql = "INSERT OR REPLACE INTO " + TABLE_FotoConductores + " ( id,descripcion, rendimiento ) VALUES (?,?, ?)";
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
        for (int i=0; i < Datos.length(); i++)
        {
            Object = Datos.getJSONObject(i);
            // Pulling items from the array

            String id = Object.getString("id");
            String descripcion = Object.getString("descripcion");
            String rendimiento = Object.getString("rendimiento");

            stmt.bindString(1,id);
            stmt.bindString(2,descripcion);
            stmt.bindString(3,rendimiento);


        }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
            //--------------------------------------------------------
            //---------------------TABLE_ImpresorasContadores------------------------------------

        jObject = new JSONObject(String.valueOf(jArray.getJSONObject(14)));
        Datos = jObject.getJSONArray("ImpresorasContadores");
            sql = "INSERT OR REPLACE INTO " + TABLE_ImpresorasContadores + " ( folio,serie, idFotoconductor,contador ) VALUES (?,?, ?,?)";
            db.beginTransactionNonExclusive();
            // db.beginTransaction();
            stmt = db.compileStatement(sql);
        for (int i=0; i < Datos.length(); i++)
        {
            Object = Datos.getJSONObject(i);
            // Pulling items from the array

            String folio = Object.getString("folio");
            String serie = Object.getString("serie");
            String idFotoconductor = Object.getString("idFotoconductor");
            String contador = Object.getString("contador");

            stmt.bindString(1,folio);
            stmt.bindString(2,serie);
            stmt.bindString(3,idFotoconductor);
            stmt.bindString(4,contador);

            Log.e("Datos",folio);
        }
            stmt.execute();
            stmt.clearBindings();

            db.setTransactionSuccessful();
            db.endTransaction();
            //-------------------------------------------------------------------------------------------------------------
        } catch (JSONException e) {
                e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }




    public void inserta()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String stringValue = "password";
        String stringValue2 = "nombre";
        try {


            String sql = "INSERT INTO " +TABLE_Usuarios+" (Login, Password,nombre) VALUES (? , ? , ?)";

            db.beginTransactionNonExclusive();
            SQLiteStatement statement = db.compileStatement(sql);

            for (int i = 2000; i < 20000; i++) {

                statement.bindString(1, ""+i);
                statement.bindString(2, "password" + i);
                statement.bindString(3, "nombre" + i);

                Log.e("Login: ",""+i ) ;

                statement.execute();
                statement.clearBindings();

            }

            db.setTransactionSuccessful();          // This commits the transaction if there were no exceptions
            db.endTransaction();


        } catch (Exception e) {
            Log.w("Exception:", e);
        }
    }
    //METODO QUE ELIMINA TODOS LOS REGISTROS PARA DEJAR EN BLANCO LA TABLA DESPUES DE
    //MANDAR LOS DATOS AL SERVIDOR
    public void BorrarTodo() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Elimina la tabla anterior si exisitia
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Usuarios);
        // Crea la tabla de nuevo
        onCreate(db);
    }

    // Inserta Nuevo Registro a Tabla
    public void insertaUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(idusers, user.getIdusers()); // idUser es AUTOINCREMENTAL POR ESO NO ES NECESARIO AGREGARLO
        values.put(Login,usuario.getLogin()); // agrega UserName a "values"
        values.put(Password, usuario.getPassword());// agrega FullName a "values"
        values.put(nombre, usuario.getNombre());// agrega FullName a "values"

        // Inserting Row
        db.insert(TABLE_Usuarios, null, values);
        db.close(); // Closing database connection
    }

    // Obtener Todos los Usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuariosList = new ArrayList<Usuario>();
// Select All Usuarios
        String selectQuery = "SELECT * FROM " + TABLE_Usuarios;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// Recorre Todos los Registros y Agrega a Lita
        if (cursor.moveToFirst()) {
            do {
                Usuario usuarios = new Usuario();
                usuarios.setLogin(cursor.getString(0));
                usuarios.setPassword(cursor.getString(1));
                usuarios.setNombre(cursor.getString(2));

// Adding contact to list
                usuariosList.add(usuarios);
            } while (cursor.moveToNext());
        }

// return contact list
        return usuariosList;
    }
/*



    // Obtener un Usuario
    public Users obtenerUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Users, new String[]{idusers,
                        UserName,FullName},idusers+ "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Users usuario = new Users(
                cursor.getString(1),
                cursor.getString(2));
        // Retorna Usuario encontrado
        return usuario;
    }

    // Obtener Todos los Usuarios
    public List<Users> obtenerTodosUsuarios() {
        List<Users> usuariosList = new ArrayList<Users>();
// Select All Usuarios
        String selectQuery = "SELECT * FROM " + TABLE_Users;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// Recorre Todos los Registros y Agrega a Lita
        if (cursor.moveToFirst()) {
            do {
                Users usuarios = new Users();
                usuarios.setIdusers(Integer.parseInt(cursor.getString(0)));
                usuarios.setUserName(cursor.getString(1));
                usuarios.setFullName(cursor.getString(2));

// Adding contact to list
                usuariosList.add(usuarios);
            } while (cursor.moveToNext());
        }

// return contact list
        return usuariosList;
    }

    // Obtener Usuarios Count
    public int ObtenerUsuariosCount() {
        String countQuery = "SELECT * FROM " + TABLE_Users;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

// return count
        return cursor.getCount();
    }
    // Actualizar Users
    public int actualizaUsers(Users usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserName,usuario.getUserName()); // UserName
        values.put(FullName,usuario.getFullName()); // FullName

// Actualizando Registro
        return db.update(TABLE_Users, values, idusers+ " = ?",
                new String[]{String.valueOf(usuario.getIdusers())});
    }

    // Borrar Usuario
    public void borraUsuario(Users usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, idusers+ " = ?",
                new String[] { String.valueOf(usuario.getIdusers())});
        db.close();
    }

    //BUSCA DATOS POR ID Y LOS RETORNA EN JSONOBJECT
    public JSONObject buscarDatos(int id){

        JSONObject jsonobj = new JSONObject();


        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("req", jsonobj.toString()));

        String Nombre = null;
        String Apellido = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c= db.rawQuery("select UserName,FullName from users where idusers= " + id,null);
        try {
            if(c.moveToFirst()){
                do{
                    jsonobj.put("idusers",id);
                    jsonobj.put("UserName",c.getString(0));
                    jsonobj.put("FullName",c.getString(1));
                }while(c.moveToNext());
            }
        }

        catch (JSONException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.getCause();
            Log.e("BASE DE TADOS","ERROR AL LEER LA BASE DE DATOS");
        }
        db.close();
        return jsonobj;

    }

    public int eliminarUsuario( int id )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i("SQLite", "DELETE: id=" + id );
        //table , whereClause, whereArgs
        return db.delete(TABLE_Users , idusers+ " = " + id ,  null);
    }

    //OBTIENE LOS DATOS DE BDLOCAL EN JSON -PARA ENVIARLOS AL SERVIDOR-
    public String MandarServDatos(){

        JSONArray jsonArray =new JSONArray();
        String Nombre = null;
        String Apellido = null;
        String Cadena="";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c= db.rawQuery("select idusers,UserName,FullName from users",null);
        try {
            if(c.moveToFirst()){
                do{
                    JSONObject jsonObj= new JSONObject();
                    jsonObj.put("idusers",c.getInt(0));
                    jsonObj.put("UserName",c.getString(1));
                    jsonObj.put("FullName",c.getString(2));

                    jsonArray.put(jsonObj);
                }while(c.moveToNext());
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            e.getCause();
            Log.e("BASE DE TADOS","ERROR AL LEER LA BASE DE DATOS");
        }
        db.close();
        //RETORNA STRING DEL JsonArray CON TODOS LOS REGISTROS
        return jsonArray.toString();

    }

    //METODO QUE ELIMINA TODOS LOS REGISTROS PARA DEJAR EN BLANCO LA TABLA DESPUES DE
    //MANDAR LOS DATOS AL SERVIDOR
    public void BorrarTodo() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Elimina la tabla anterior si exisitia
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Crea la tabla de nuevo
        onCreate(db);
    }

*/


}
